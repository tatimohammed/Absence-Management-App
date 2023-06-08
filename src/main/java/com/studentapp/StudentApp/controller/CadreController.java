package com.studentapp.StudentApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentapp.StudentApp.dao.EtudiantRepository;
import com.studentapp.StudentApp.model.Absence;
import com.studentapp.StudentApp.model.Etudiant;
import com.studentapp.StudentApp.model.Matiere;
import com.studentapp.StudentApp.model.Module;
import com.studentapp.StudentApp.model.Niveau;
import com.studentapp.StudentApp.model.Utilisateur;
import com.studentapp.StudentApp.service.AbsenceServiceImpl;
import com.studentapp.StudentApp.service.EtudiantServiceImpl;
import com.studentapp.StudentApp.service.MatiereServiceImpl;
import com.studentapp.StudentApp.service.ModuleServiceImpl;
import com.studentapp.StudentApp.service.NiveauServiceImpl;
import com.studentapp.StudentApp.service.UtilisateurServiceImpl;
import com.studentapp.StudentApp.utils.AbsenceTable;
import com.studentapp.StudentApp.utils.Message;

@Controller
@RequestMapping("/cadre")
public class CadreController {

	@Autowired
	private NiveauServiceImpl niveauServiceImpl;

	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;

	@Autowired
	private EtudiantServiceImpl etudiantServiceImpl;

	@Autowired
	private ModuleServiceImpl moduleServiceImpl;

	@Autowired
	private MatiereServiceImpl matiereServiceImpl;

	@Autowired
	private AbsenceServiceImpl absenceServiceImpl;

	public void selector(Model model) {
		List<Niveau> all = niveauServiceImpl.getAllClasses();

		for (Niveau n : all) {
			System.out.println(n.getAlias());
		}
		model.addAttribute("allNiveau", all);

		List<Module> modules = moduleServiceImpl.getAllModules();
		for (Module m : modules) {
			System.out.println(m.getTitre());
		}
		model.addAttribute("allModule", modules);
	}

	@GetMapping("/homeCadre")
	public String showHome(Model model) {
		selector(model);

		return "cadre/homeCadre";
	}

	@PostMapping("/list")
	public String listAbsence(@RequestParam(name = "niveauInput", required = false, defaultValue = "0") Long niveau,
			@RequestParam(name = "moduleInput", required = false, defaultValue = "0") String module,
			@RequestParam(name = "dateInput", required = false, defaultValue = "") String date, Model model)
			throws ParseException {
		selector(model);

		if (module.equals("0") && date.equals("")) {
			Set<Absence> absences = absenceServiceImpl.getAbsenceByNiveau(niveau);
			Set<AbsenceTable> absenceTables = absenceServiceImpl.getAbsenceData(absences);

			model.addAttribute("absences", absenceTables);

		} else if (niveau.toString().equals("0") && date.equals("")) {
			Set<Matiere> matieres = matiereServiceImpl.getMatiereByModule(Long.parseLong(module));
			Set<Absence> absences = new HashSet<>();
			for (Matiere m : matieres) {
				Set<Absence> absence = absenceServiceImpl.getAbsenceByMatiere(m.getIdMatiere());
				absences.addAll(absence);
			}
			for (Absence a : absences) {
				System.out.println(a.getDateHeureDebutAbsence());
			}
			Set<AbsenceTable> absenceTables = absenceServiceImpl.getAbsenceData(absences);

			model.addAttribute("absences", absenceTables);

		} else if (niveau.toString().equals("0") && module.equals("0")) {
			System.out.println(date);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

			Date dateF = format.parse(date);
			System.out.println(dateF);

			Set<Absence> absences = absenceServiceImpl.getAbsenceByDate(dateF);
			Set<AbsenceTable> absenceTables = absenceServiceImpl.getAbsenceData(absences);

			model.addAttribute("absences", absenceTables);
		}
//		// module fetch
//		Set<Matiere> matieres = matiereServiceImpl.getMatiereByModule(Long.parseLong(module));
//		Set<Absence> absences1 = new HashSet<>();
//		for (Matiere m : matieres) {
//			Set<Absence> absence = absenceServiceImpl.getAbsenceByMatiere(m.getIdMatiere());
//			absences1.addAll(absence);
//		}
//		for (Absence a : absences1) {
//			System.out.println(a.getDateHeureDebutAbsence());
//		}
//		Set<AbsenceTable> absenceTables1 = absenceServiceImpl.getAbsenceData(absences1);
//
//		// date fetch
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//
//		Date dateF = format.parse(date);
//		System.out.println(dateF);
//
//		Set<Absence> absences2 = absenceServiceImpl.getAbsenceByDate(dateF);
//		Set<AbsenceTable> absenceTables2 = absenceServiceImpl.getAbsenceData(absences2);
//
//		// class fetch
//		Set<Absence> absences3 = absenceServiceImpl.getAbsenceByNiveau(niveau);
//		Set<AbsenceTable> absenceTables3 = absenceServiceImpl.getAbsenceData(absences3);
//
//		// All
//		Set<AbsenceTable> absenceTables = new HashSet<>(absenceTables1);
//		absenceTables.retainAll(absenceTables2);
//		absenceTables.retainAll(absenceTables3);
//
//		model.addAttribute("absences", absenceTables);

		return "cadre/homeCadre";
	}

	@GetMapping("/delete")
	public String deleteAbsence(@RequestParam(name = "absenceId") Long absenceId, Model model) {
		selector(model);
		absenceServiceImpl.deleteAbsence(absenceId);

		return "cadre/homeCadre";
	}

	@PostMapping("/update")
	public String updateAbsence(@RequestParam(name = "Id", required = false) Long Id,
			@ModelAttribute("AbsenceToUpdate") Absence absenceToUpdate, @RequestParam(name = "module") Long moduleId,
			@RequestParam(name = "startDate") String sDate, @RequestParam(name = "endDate") String eDate,
			@RequestParam(name = "nom") String nom, Model model) throws ParseException {
		selector(model);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

		Date dateS = format.parse(sDate);
		Date dateE = format.parse(eDate);
		Matiere m = matiereServiceImpl.getMatiereByModuleAndNom(moduleId, nom);
		System.out.println(Id);
		absenceServiceImpl.updateAbsence(Id, absenceToUpdate, m, dateS, dateE);
		Message msg = new Message();
		msg.setContent("Absence: cne: " + absenceServiceImpl.getById(Id).getEtudiant().getCne() + " Has been Updated!");
		model.addAttribute("msg", msg.getContent());
		return "cadre/homeCadre";
	}

	@GetMapping("/edit")
	public String editAbsence(@RequestParam(name = "absenceId") Long absenceId, Model model) {
		selector(model);

		Absence a = absenceServiceImpl.getById(absenceId);
		model.addAttribute("AbsenceToUpdate", a);

		return "cadre/updateAbsence";
	}

	@GetMapping("/studentMgn")
	public String showStudentMgn(Model model) {
		model.addAttribute("studentToAdd", new Etudiant());

		List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();

		model.addAttribute("etudiants", etudiants);
		model.addAttribute("studentToUpdate", new Etudiant());
		model.addAttribute("studentToDelete", new Etudiant());
		

		return "cadre/StudentMgn";
	}

	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute(name = "studentToAdd") Etudiant etd,
			@RequestParam(name = "cne") String cne, @RequestParam(name = "birthday") String birthday, Model model)
			throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date birthdayD = format.parse(birthday);

		etd.setCne(cne);
		etd.setDateNaissance(birthdayD);

		etudiantServiceImpl.addEtudiant(etd);

		List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();

		model.addAttribute("etudiants", etudiants);

		return "redirect:/cadre/studentMgn";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam(name = "etudiantSelected", required = false) String id, Model model) {
		Etudiant etd = etudiantServiceImpl.getById(Long.parseLong(id));
		model.addAttribute("studentToUpdate", etd);
		model.addAttribute("studentToDelete", new Etudiant());
		model.addAttribute("studentToAdd", new Etudiant());
		List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();

		model.addAttribute("etudiants", etudiants);
		return "cadre/StudentMgn";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam(name = "etudiantSelected", required = false) String id, Model model) {
		Etudiant etd = etudiantServiceImpl.getById(Long.parseLong(id));
		model.addAttribute("studentToUpdate", etd);
		model.addAttribute("studentToDelete", new Etudiant());
		model.addAttribute("studentToAdd", new Etudiant());
		List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();

		model.addAttribute("etudiants", etudiants);
		return "cadre/StudentMgn";
	}

	@PostMapping("/editStudent")
	public String editStudent(@RequestParam(name = "stdid") String id, @ModelAttribute("studentToUpdate") Etudiant e,
			@RequestParam(name = "dateto") String date, Model model) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date birthdayD = format.parse(date);
		e.setDateNaissance(birthdayD);
		etudiantServiceImpl.updateEtudiant(Long.parseLong(id), e);
		List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();

		model.addAttribute("etudiants", etudiants);
		return "redirect:/cadre/studentMgn";
	}
	
	@GetMapping("/listStudent")
	public String listStudent(Model model) {
		List<Niveau> all = niveauServiceImpl.getAllClasses();

		for (Niveau n : all) {
			System.out.println(n.getAlias());
		}
		model.addAttribute("allNiveau", all);
		return "cadre/StudentList";
	}

}
