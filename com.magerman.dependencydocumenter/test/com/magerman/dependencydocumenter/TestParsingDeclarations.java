package com.magerman.dependencydocumenter;

import junit.framework.TestCase;
import lotus.domino.Database;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;

public class TestParsingDeclarations extends TestCase {
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

	public void testRemovecommentsNormalCase() {
		DesignElement test = DesignElement.testDesignElement();
		test.setDeclarations("Option Public\r\n" + "Option Declare\r\n"
				+ "\r\n" + "\r\n" + "Use \"OpenLogFunctions\"\r\n"
				+ "Use \"Class: Content Documents\"\r\n"
				+ "Use \"Class Template Build\"");
		test.setName("Normal case with no comments");
		test.parsedeclarations();
		assertTrue(test.getParentReferences().contains("OpenLogFunctions"));
		assertTrue(test.getParentReferences().contains(
				"Class: Content Documents"));
		assertTrue(test.getParentReferences().contains("Class Template Build"));
		System.out.println(test);
	}

	public void testRemoveREMcomments() {
		DesignElement test = DesignElement.testDesignElement();
		test.setDeclarations("Option Public\r\n" + "Option Declare\r\n"
				+ "\r\n" + "%REM\r\n" + "Use \"OpenLogFunctions\"\r\n" + "\r\n"
				+ "\r\n" + "%END REM\r\n"
				+ "Use \"Class: Content Documents\"\r\n"
				+ "Use \"Class Template Build\"");
		test.setName("Case containing REMS");
		test.parsedeclarations();
		assertFalse(test.getParentReferences().contains("OpenLogFunctions"));
		assertTrue(test.getParentReferences().contains(
				"Class: Content Documents"));
		assertTrue(test.getParentReferences().contains("Class Template Build"));
		System.out.println(test);
	}

	public void testRemoveApostrophescomments() {
		DesignElement test = DesignElement.testDesignElement();
		test.setDeclarations("Option Public\r\n" + "Option Declare\r\n"
				+ "\r\n" + "\r\n" + "'Use \"OpenLogFunctions\"\r\n" + "\r\n"
				+ "\r\n" + "Use \"Class: Content Documents\"\r\n"
				+ "Use \"Class Template Build\"");
		test.setName("Case containing an apostrophe");
		test.parsedeclarations();
		assertFalse(test.getParentReferences().contains("OpenLogFunctions"));
		assertTrue(test.getParentReferences().contains(
				"Class: Content Documents"));
		assertTrue(test.getParentReferences().contains("Class Template Build"));
		System.out.println(test);
	}

}
