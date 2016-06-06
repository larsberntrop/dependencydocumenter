package com.magerman.dependencydocumenter;

import java.io.File;

import junit.framework.TestCase;
import lotus.domino.Database;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;

public class TestGifCreation extends TestCase {
	Database db;

	protected void setUp() {
		Session session;
		NotesThread.sinitThread();

		try {
			session = NotesFactory.createSession();
			db = session
					.getDatabase("albis",
							"Development\\DependencyTrackerr\\Efsr_(3_0)_Field_Service_Local_Dev.nsf");
		} catch (NotesException e) {
			e.printStackTrace();
		}

	}

	protected void tearDown() {
		NotesThread.stermThread();
	}

	public void testGifCreation() {

		File f = new File(
				"H:\\Current Projects\\dependencydocumenter\\ExportDxl.xml");
		// File f = new File(
		// "H:\\Current Projects\\dependencydocumenter\\test1.dxl");

		DependencyAnalyser d = new DependencyAnalyser(db);
		d.createDocumentationPageFromDXLFile(f);

	}

	public void testGenerationDXLFromImage() {
		DependencyAnalyser d = new DependencyAnalyser(db);
		// StringBuilder hi = d.createDXLStringBuilderFromImage(new
		// File("H:\\Current Projects\\dependencytracker\\gifs\\To Do - Button.gif"));
		StringBuilder hi = d.createDXLStringBuilderFromImage(new File(
				"H:\\Current Projects\\dependencydocumenter\\gifs\\out.gif"));
		// StringBuilder hi = d.createDXLStringBuilderFromImage(new
		// File("H:\\Current Projects\\dependencytracker\\gifs\\close.gif"));
		d.createDocumentationPageFromStringBuilder(hi);
	}

	public void testGifToBase64() {

		DependencyAnalyser d = new DependencyAnalyser(db);
		System.out
				.println(d.convertGifToBaseT64(d.getOutputPictureFileHandle()));

	}
}
