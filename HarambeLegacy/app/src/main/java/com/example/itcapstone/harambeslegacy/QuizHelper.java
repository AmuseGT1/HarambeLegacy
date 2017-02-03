package com.example.itcapstone.harambeslegacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "burglarkitten";
	// tasks table name
	private static final String TABLE_QUEST = "kitten";
	// tasks Table Columns names
	private static final String KEY_ID = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // correct option
	private static final String KEY_OPTA = "opta"; // option a
	private static final String KEY_OPTB = "optb"; // option b
	private static final String KEY_OPTC = "optc"; // option c

	private SQLiteDatabase dbase;

	public QuizHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
		db.execSQL(sql);
		addQuestion();
		// db.close();
	}

	private void addQuestion() {
		Question q1 = new Question("Where was Harambe born?", "Gladys Porter Zoo", "Cincinnati Zoo", "Amazon", "Gladys Porter Zoo");
		this.addQuestion(q1);
		Question q2 = new Question("What type of Gorilla was Harambe?", "Mountain Gorilla", "Western Lowland Gorilla", "Cross River Gorilla", "Western Lowland Gorilla");
		this.addQuestion(q2);
		Question q3 = new Question("What are the greatest threats to Gorillas?", "Little Kids", "Poaching & Habitat Destruction", "Being Held In Captivity", "Poaching & Habitat Destruction");
		this.addQuestion(q3);
		Question q4 = new Question("What year was Harambe born?", "1995", "1999", "2002", "1999");
		this.addQuestion(q4);
		Question q5 = new Question("On what day did Harambe die?", "May 28, 2016", "August 19, 2016", "January 15, 2016", "May 28, 2016");
		this.addQuestion(q5);
		Question q6 = new Question("How much can adult gorillas weight?", "250 lbs.", "440 lbs.", "600 lbs.", "440 lbs.");
		this.addQuestion(q6);
		Question q7 = new Question("How long did Harambe live?", "19 years", "10 years", "17 years", "17 years");
		this.addQuestion(q7);
		Question q8 = new Question("How tall can adult gorillas get?", "4 ft.", "5ft.", "6 ft.", "6 ft.");
		this.addQuestion(q8);
		Question q9 = new Question("What country are gorillas native to?", "China", "South America", "Africa", "Africa");
		this.addQuestion(q9);
		Question q10 = new Question("For the most part, gorillas are:", "Herbivores", "Carnivores", "Omnivores", "Herbivores");
		this.addQuestion(q10);
		Question q11 = new Question("Gorillas are:", "The world's largest primates", "kidnappers", "Only found in captivity", "The world's largest primates");
		this.addQuestion(q11);
		Question q12 = new Question("A group of gorilla can have a territory of up to:", "5 sq. mi.", "9 sq. mi.", "16 sq. mi.", "16 sq. mi.");
		this.addQuestion(q12);
		Question q13 = new Question("In the wild, gorillas live:", "In groups", "Solitary lives", "Only in Zoos", "In groups");
		this.addQuestion(q13);
		Question q14 = new Question("A gorilla can live for:", "15-20 years", "30-40 years", "40-50 years", "40-50 years");
		this.addQuestion(q14);
		Question q15 = new Question("How many primary species of gorilla are there in the world?", "1", "2", "4", "2");
		this.addQuestion(q15);
		Question q16 = new Question("What is the current gorilla population in the world?", "20,000", "100,000", "200,000+", "200,000+");
		this.addQuestion(q16);
		Question q17 = new Question("What is the name of the famous gorilla that knows sign language?", "Harambe", "King Kong", "Koko", "Koko");
		this.addQuestion(q17);
		Question q18 = new Question("What distinguishing feature do gorillas have that's similar to humans fingerprints?", "Fingerprints", "Nose prints", "Teeth", "Nose prints");
		this.addQuestion(q18);
		Question q19 = new Question("Harambe is a Swahili name.  It means what?", "Working together", "Immortal", "Life goes on", "Working together");
		this.addQuestion(q19);
		Question q20 = new Question("At what age do female gorillas start to give birth?", "10 years old", "18 years old", "16 years old", "10 years old");
		this.addQuestion(q20);
		Question q21 = new Question("How close is gorilla dna to humans?", "70-80%", "80-90%", "95-99%", "95-99%");
		this.addQuestion(q21);
		// END
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());

		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		// Random pull through database for random questions.
		Cursor cursor = dbase.rawQuery(selectQuery + " ORDER BY RANDOM()", null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));

				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}


}
