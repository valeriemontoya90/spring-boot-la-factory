package com.monapp.entity;

public interface Views {
	public interface Common{}
	
	public interface Formateur extends Common{}
	public interface FormateurWithCompetence extends Formateur{}
	public interface FormateurWithDisponibilite extends Formateur{}
	public interface FormateurWithFormation extends Formateur{}
	public interface FormateurWithAll extends FormateurWithCompetence, FormateurWithDisponibilite, FormateurWithFormation{}
	
	public interface Formation extends Common{}
	public interface FormationWithFormateur extends Common{}
	public interface FormationWithMatiere extends Common{}
	
	public interface Gestionnaire extends Common{}
	public interface GestionnaireWithFormation extends Gestionnaire{}
	
	public interface Technicien extends Common{}
	public interface TechnicienWithMateriel extends Technicien{}
	
	public interface CursusDeFormation extends Common{}
	public interface CursusDeFormationWithStagiaire extends CursusDeFormation{}
	public interface CursusDeFormationWithGestionnaire extends CursusDeFormation{}
	
	public interface Stagiaire extends Common{}
	public interface StagiaireWithCursusDeFormation extends Stagiaire{}
	public interface StagiaireWithOrdinateur extends Stagiaire{}
	public interface StagiaireWithFormationAndOrdinateur extends Stagiaire{}
	
	public interface Disponibilite extends Common{}
	public interface DisponibiliteWithFormateur extends Disponibilite{}
	
	public interface Matiere extends Common{}
	public interface MatiereWithCompetence extends Matiere{}
	public interface MatiereWithFormation extends Matiere{}
	public interface MatiereWithMateriel extends Matiere{}
	
	public interface Competence extends Common{}
	public interface CompetenceWithMatiere extends Competence{}
	public interface CompetenceWithLevel extends Competence{}
	public interface CompetenceWithFormateur extends Competence{}
	public interface CompetenceWithMatiereAndLevel extends Competence{}
	public interface CompetenceWithAll extends Competence{}
	
	public interface Materiel extends Common{}
	public interface MaterielWithTechnicien extends Materiel{}
	public interface MaterielWithMatiere extends Materiel{}

}
