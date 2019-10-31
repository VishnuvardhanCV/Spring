package com.simplebootapp.DAO;

import java.io.FileInputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Value;

public class EmployeeDAOUtil {
	private String firebase_path = "C://Users//vishnu.vardhan//Desktop//Java//WEB//EmployeeApp//demo//src//main//java//com//simplebootapp//DAO//ServiceAccountKey.json";
	public  Firestore getRepo()  {
		try {
		FileInputStream serviceAccount =
				  new FileInputStream(firebase_path);

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://fir-2d3e9.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
				Firestore db = FirestoreClient.getFirestore();
				return db;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
