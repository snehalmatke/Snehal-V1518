package sonarqube_demo.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {

	public String getMessage() {
		String str = "Finding bugs";
		Object obj = getObject();
		System.out.println(obj.toString());

		return str;
	}

	private Object getObject() {
		return "finding bugs successfully";
	}

}
