package com.jnasatlx;

import static com.jnasatlx.TlxLocalization.TlxLanguage.ENGLISH;
import static com.jnasatlx.TlxLocalization.TlxLanguage.GERMAN;

import java.util.HashMap;

/**
 * This class holds all information needed for the localization of the test.<br>
 * It is designed for easy enhancement with more languages.<br>
 * All english texts in this file are taken from the file <code>nasatlx.html</code> by Keith Vertanen.<br>
 * All german texts in this file are taken from the file <code>nasatlx_german.html</code>, where the German translation was done by Christian Lehsing and Katharina Seifert.<br>
 * 
 * @see TlxLocalization
 * @author Keith Vertanen, Christian Lehsing, Katharina Seifert, Bernhard Glaser
 * @version 1.0
 */

public class TlxLocalization{

	public enum TlxLanguage {
		ENGLISH,
		GERMAN
	}

	private static TlxLanguage language = ENGLISH;
	private static HashMap<String, HashMap<TlxLanguage, String>> localizationMap = new HashMap<String, HashMap<TlxLanguage, String>>();

	static{

		//scale0

		HashMap<TlxLanguage, String> scale0Title = new HashMap<TlxLanguage, String>();
		scale0Title.put(ENGLISH, "Mental Demand");
		scale0Title.put(GERMAN, "Geistige Anforderung");
		localizationMap.put("scale0Title", scale0Title);

		HashMap<TlxLanguage, String> scale0Left = new HashMap<TlxLanguage, String>();
		scale0Left.put(ENGLISH, "Low");
		scale0Left.put(GERMAN, "Gering");
		localizationMap.put("scale0Left", scale0Left);

		HashMap<TlxLanguage, String> scale0Right = new HashMap<TlxLanguage, String>();
		scale0Right.put(ENGLISH, "High");
		scale0Right.put(GERMAN, "Hoch");
		localizationMap.put("scale0Right", scale0Right);

		HashMap<TlxLanguage, String> scale0Desc = new HashMap<TlxLanguage, String>();
		scale0Desc.put(ENGLISH, "How much mental and perceptual activity was required (e.g. thinking, deciding, calculating, remembering, looking, searching, etc)? Was the task easy or demanding, simple or complex, exacting or forgiving?");
		scale0Desc.put(GERMAN, "Wie viel geistige Anforderung war bei der Informationsaufnahme und bei der Informationsverarbeitung erforderlich (z.B. Denken, Entscheiden, Rechnen, Erinnern, Hinsehen, Suchen ...)? War die Aufgabe leicht oder anspruchsvoll, einfach oder komplex, erfordert sie hohe Genauigkeit oder ist sie fehlertolerant?");
		localizationMap.put("scale0Desc", scale0Desc);

		//scale1

		HashMap<TlxLanguage, String> scale1Title = new HashMap<TlxLanguage, String>();
		scale1Title.put(ENGLISH, "Physical Demand");
		scale1Title.put(GERMAN, "K�rperliche Anforderung");
		localizationMap.put("scale1Title", scale1Title);

		HashMap<TlxLanguage, String> scale1Left = new HashMap<TlxLanguage, String>();
		scale1Left.put(ENGLISH, "Low");
		scale1Left.put(GERMAN, "Gering");
		localizationMap.put("scale1Left", scale1Left);

		HashMap<TlxLanguage, String> scale1Right = new HashMap<TlxLanguage, String>();
		scale1Right.put(ENGLISH, "High");
		scale1Right.put(GERMAN, "Hoch");
		localizationMap.put("scale1Right", scale1Right);

		HashMap<TlxLanguage, String> scale1Desc = new HashMap<TlxLanguage, String>();
		scale1Desc.put(ENGLISH, "How much physical activity was required (e.g. pushing, pulling, turning, controlling, activating, etc)? Was the task easy or demanding, slow or brisk, slack or strenuous, restful or laborious?");
		scale1Desc.put(GERMAN, "Wie viel k�rperliche Aktivit�t war erforderlich (z.B. ziehen, dr�cken, drehen, steuern, aktivieren ...)? War die Aufgabe leicht oder schwer, einfach oder anstrengend, erholsam oder m�hselig?");
		localizationMap.put("scale1Desc", scale1Desc);

		//scale2

		HashMap<TlxLanguage, String> scale2Title = new HashMap<TlxLanguage, String>();
		scale2Title.put(ENGLISH, "Temporal Demand");
		scale2Title.put(GERMAN, "Zeitliche Anforderung");
		localizationMap.put("scale2Title", scale2Title);

		HashMap<TlxLanguage, String> scale2Left = new HashMap<TlxLanguage, String>();
		scale2Left.put(ENGLISH, "Low");
		scale2Left.put(GERMAN, "Gering");
		localizationMap.put("scale2Left", scale2Left);

		HashMap<TlxLanguage, String> scale2Right = new HashMap<TlxLanguage, String>();
		scale2Right.put(ENGLISH, "High");
		scale2Right.put(GERMAN, "Hoch");
		localizationMap.put("scale2Right", scale2Right);

		HashMap<TlxLanguage, String> scale2Desc = new HashMap<TlxLanguage, String>();
		scale2Desc.put(ENGLISH, "How much time pressure did you feel due to the rate of pace at which the tasks or task elements occurred? Was the pace slow and leisurely or rapid and frantic?");
		scale2Desc.put(GERMAN, "Wie viel Zeitdruck empfanden Sie hinsichtlich der H�ufigkeit oder dem Takt mit dem die Aufgaben oder Aufgabenelemente auftraten? War die Aufgabe langsam und geruhsam oder schnell und hektisch?");
		localizationMap.put("scale2Desc", scale2Desc);

		//scale3

		HashMap<TlxLanguage, String> scale3Title = new HashMap<TlxLanguage, String>();
		scale3Title.put(ENGLISH, "Performance");
		scale3Title.put(GERMAN, "Leistung");
		localizationMap.put("scale3Title", scale3Title);

		HashMap<TlxLanguage, String> scale3Left = new HashMap<TlxLanguage, String>();
		scale3Left.put(ENGLISH, "Good");
		scale3Left.put(GERMAN, "Gut");
		localizationMap.put("scale3Left", scale3Left);

		HashMap<TlxLanguage, String> scale3Right = new HashMap<TlxLanguage, String>();
		scale3Right.put(ENGLISH, "Poor");
		scale3Right.put(GERMAN, "Schlecht");
		localizationMap.put("scale3Right", scale3Right);

		HashMap<TlxLanguage, String> scale3Desc = new HashMap<TlxLanguage, String>();
		scale3Desc.put(ENGLISH, "How successful do you think you were in accomplishing the goals of the task set by the experimenter (or yourself)? How satisfied were you with your performance in accomplishing these goals?");
		scale3Desc.put(GERMAN, "Wie erfolgreich haben Sie Ihrer Meinung nach die vom Versuchsleiter (oder Ihnen selbst) gesetzten Ziele erreicht? Wie zufrieden waren Sie mit Ihrer Leistung bei der Verfolgung dieser Ziele?");
		localizationMap.put("scale3Desc", scale3Desc);

		//scale4

		HashMap<TlxLanguage, String> scale4Title = new HashMap<TlxLanguage, String>();
		scale4Title.put(ENGLISH, "Effort");
		scale4Title.put(GERMAN, "Anstrengung");
		localizationMap.put("scale4Title", scale4Title);

		HashMap<TlxLanguage, String> scale4Left = new HashMap<TlxLanguage, String>();
		scale4Left.put(ENGLISH, "Low");
		scale4Left.put(GERMAN, "Gering");
		localizationMap.put("scale4Left", scale4Left);

		HashMap<TlxLanguage, String> scale4Right = new HashMap<TlxLanguage, String>();
		scale4Right.put(ENGLISH, "High");
		scale4Right.put(GERMAN, "Hoch");
		localizationMap.put("scale4Right", scale4Right);

		HashMap<TlxLanguage, String> scale4Desc = new HashMap<TlxLanguage, String>();
		scale4Desc.put(ENGLISH, "How hard did you have to work (mentally and physically) to accomplish your level of performance?");
		scale4Desc.put(GERMAN, "Wie hart mussten Sie arbeiten, um Ihren Grad an Aufgabenerf�llung zu erreichen?");
		localizationMap.put("scale4Desc", scale4Desc);

		//scale5

		HashMap<TlxLanguage, String> scale5Title = new HashMap<TlxLanguage, String>();
		scale5Title.put(ENGLISH, "Frustration");
		scale5Title.put(GERMAN, "Frustration");
		localizationMap.put("scale5Title", scale5Title);

		HashMap<TlxLanguage, String> scale5Left = new HashMap<TlxLanguage, String>();
		scale5Left.put(ENGLISH, "Low");
		scale5Left.put(GERMAN, "Gering");
		localizationMap.put("scale5Left", scale5Left);

		HashMap<TlxLanguage, String> scale5Right = new HashMap<TlxLanguage, String>();
		scale5Right.put(ENGLISH, "High");
		scale5Right.put(GERMAN, "Hoch");
		localizationMap.put("scale5Right", scale5Right);

		HashMap<TlxLanguage, String> scale5Desc = new HashMap<TlxLanguage, String>();
		scale5Desc.put(ENGLISH, "How insecure, discouraged, irritated, stressed and annoyed versus secure, gratified, content, relaxed and complacent did you feel during the task?");
		scale5Desc.put(GERMAN, "Wie unsicher, entmutigt, irritiert, gestresst und ver�rgert (versus sicher, best�tigt, zufrieden, entspannt und zufrieden mit sich selbst) f�hlten Sie sich w�hrend der Aufgabe?");
		localizationMap.put("scale5Desc", scale5Desc);

		//quest1

		HashMap<TlxLanguage, String> quest1Title = new HashMap<TlxLanguage, String>();
		quest1Title.put(ENGLISH, "Task Questionnaire - Part 1");
		quest1Title.put(GERMAN, "Fragebogen - Teil 1");
		localizationMap.put("quest1Title", quest1Title);

		HashMap<TlxLanguage, String> quest1Desc = new HashMap<TlxLanguage, String>();
		quest1Desc.put(ENGLISH, "Click on each scale at the point that best indicates your experience of the task ");
		quest1Desc.put(GERMAN, "Klicken Sie in jeder Skale auf den Punkt, der Ihre Erfahrung im Hinblick auf die Aufgabe am besten verdeutlicht.");
		localizationMap.put("quest1Desc", quest1Desc);

		//quest2

		HashMap<TlxLanguage, String> quest2Title = new HashMap<TlxLanguage, String>();
		quest2Title.put(ENGLISH, "Task Questionnaire - Part 2");
		quest2Title.put(GERMAN, "Fragebogen - Teil 2");
		localizationMap.put("quest2Title", quest2Title);

		HashMap<TlxLanguage, String> quest2Desc = new HashMap<TlxLanguage, String>();
		quest2Desc.put(ENGLISH, "One each of the following 15 screens, click on the scale title that represents the more important contributor to workload for the task ");
		quest2Desc.put(GERMAN, "Klicken Sie in jedem der 15 nachfolgenden Fenster auf die Beanspruchungsdimension, die f�r das Gesamtempfinden hinsichtlich der Aufgabe die jeweils bedeutsamere war. ");
		localizationMap.put("quest2Desc", quest2Desc);

		//quest3

		HashMap<TlxLanguage, String> quest3Title = new HashMap<TlxLanguage, String>();
		quest3Title.put(ENGLISH, "Task Questionnaire - Part 2");
		quest3Title.put(GERMAN, "Fragebogen - Teil 2");
		localizationMap.put("quest3Title", quest3Title);

		HashMap<TlxLanguage, String> quest3Desc = new HashMap<TlxLanguage, String>();
		quest3Desc.put(ENGLISH, "Click on the factor that represents the more important contributor to workload for the task");
		quest3Desc.put(GERMAN, "Klicken Sie auf die Dimension, die den jeweils wichtigeren Beitrag zur Arbeitsbelastung hinsichtlich der Aufgabe darstellt.");
		localizationMap.put("quest3Desc", quest3Desc);

		//continueButton

		HashMap<TlxLanguage, String> continueButton = new HashMap<TlxLanguage, String>();
		continueButton.put(ENGLISH, "Continue");
		continueButton.put(GERMAN, "Weiter");
		localizationMap.put("continueButton", continueButton);

		//or

		HashMap<TlxLanguage, String> or = new HashMap<TlxLanguage, String>();
		or.put(ENGLISH, "or");
		or.put(GERMAN, "oder");
		localizationMap.put("or", or);

		//rating

		HashMap<TlxLanguage, String> rating = new HashMap<TlxLanguage, String>();
		rating.put(ENGLISH, "Rating");
		rating.put(GERMAN, "Bewertung");
		localizationMap.put("rating", rating);

		//tally 

		HashMap<TlxLanguage, String> tally = new HashMap<TlxLanguage, String>();
		tally.put(ENGLISH, "Tally");
		tally.put(GERMAN, "Klicks");
		localizationMap.put("tally", tally);

		//weight

		HashMap<TlxLanguage, String> weight = new HashMap<TlxLanguage, String>();
		weight.put(ENGLISH, "Weight");
		weight.put(GERMAN, "Wichtung");
		localizationMap.put("weight", weight);

		//overall

		HashMap<TlxLanguage, String> overall = new HashMap<TlxLanguage, String>();
		overall.put(ENGLISH, "Overall");
		overall.put(GERMAN, "Gesamtbeanspruchung");
		localizationMap.put("overall", overall);
	}

	public static String[] getAllKeyWords(){
		return localizationMap.keySet().toArray(new String[0]);
	}

	public static String getTranslation(String keyWord){
		HashMap<TlxLanguage, String> h = localizationMap.get(keyWord);
		if (h != null){
			return h.get(language);
		}
		else{
			return null;
		}
	}

	public static void setLanguage(TlxLanguage language){
		TlxLocalization.language = language;
	}

	public static TlxLanguage getLanguage(){
		return language;
	}

}
