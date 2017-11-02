package simplechat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import simplechat1.common.ChatIF;

public class ServerConsole implements ChatIF {

	EchoServer server;

	public ServerConsole(int port) throws IOException {
		server = new EchoServer(port);
		server.listen();
	}

	@Override
	public void display(String message) {
		System.out.println("> " + message);
	}

	@Override
	public String scan(String prompt) {
		// TODO Auto-generated method stub
		return null;
	}

	public void acceptFromServer() {
		try {
			BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
			String message;

			while (true) {
				message = fromConsole.readLine();
				server.sendToAllClients("Server Msg> " + message);
			}
		} catch (Exception ex) {
			System.out.println("Unexpected error while reading from console!");
		}
	}

	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = EchoServer.DEFAULT_PORT; // Set port to 5555
		}

		try {
			ServerConsole sv = new ServerConsole(port);
			sv.acceptFromServer();
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}

	}

}
