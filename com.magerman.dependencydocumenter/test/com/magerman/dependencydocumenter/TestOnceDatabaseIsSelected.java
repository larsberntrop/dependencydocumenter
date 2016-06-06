package com.magerman.dependencydocumenter;

import java.io.File;

import junit.framework.TestCase;
import lotus.domino.Database;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;

public class TestOnceDatabaseIsSelected extends TestCase {
	Database db;
	Session session;

	protected void setUp() {

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

	public void testONceDbisselected() {

		DependencyAnalyser da = new DependencyAnalyser(db);
		String pathToDotExe;
		try {
			pathToDotExe = session.getEnvironmentString("pathtographvizdotexe");
			if (pathToDotExe.equals("")) {
				System.out.println("no path to dotexe");
			} else {
				File f = new File(pathToDotExe);
				if (f.exists() && !f.isDirectory()) {
					da.setPathToDotExe(pathToDotExe);
					assertTrue(da.run());
				}
			}
		} catch (NotesException e) {
			e.printStackTrace();
		}

	}
}
