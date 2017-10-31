package simplechat1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import simplechat1.client.ChatClient;
import simplechat1.common.ChatIF;

public class ServerConsole implements ChatIF {

	@Override
	public void display(String message) {
		System.out.println("> " + message);
	}

	@Override
	public String scan(String prompt) {
		// TODO Auto-generated method stub
		return null;
	}

	ChatClient server;

	public void accept() {
		try {
			BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
			String message;

			while (true) {
				message = fromConsole.readLine();
				server.handleMessageFromServer(message);
			}
		} catch (Exception ex) {
			System.out.println("Unexpected error while reading from console!");
		}
	}

}
