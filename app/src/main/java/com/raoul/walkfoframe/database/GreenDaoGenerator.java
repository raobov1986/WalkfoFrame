package com.raoul.walkfoframe.database;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
	public static void main(String[] args) {
		Schema schema = new Schema(1, "com.holliwoodwalkoffame.app.database");
		createTables(schema);

		try {
			new DaoGenerator().generateAll(schema,
					"D:/HOLIWOODWORKBENCH/HoliwoodWalkOfFame/src");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTables(Schema schema) {

		// table student
		Entity Wofhonorees = schema.addEntity("Wofhonorees");
		Wofhonorees.addStringProperty("honoreeID");
		Wofhonorees.addStringProperty("bioThumbnail");
		Wofhonorees.addStringProperty("biography");
		Wofhonorees.addStringProperty("birthCity");
		Wofhonorees.addStringProperty("birthCountry");
		Wofhonorees.addStringProperty("birthDate");
		Wofhonorees.addStringProperty("createdTimeStamp");
		Wofhonorees.addStringProperty("deathCity");
		Wofhonorees.addStringProperty("deathState");
		Wofhonorees.addStringProperty("education");
		Wofhonorees.addStringProperty("ethnicity");
		Wofhonorees.addStringProperty("inductionDate");
		Wofhonorees.addStringProperty("fullName");
		Wofhonorees.addStringProperty("nameFullFirst");
		Wofhonorees.addStringProperty("nameFullFirstLetter");
		Wofhonorees.addStringProperty("nameFullLast");

	}
}
