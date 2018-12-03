package chatServer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Server {
	public static void main(String[] args) {
		// new ServerFrame().start();
		JFrame jf = new ServerFrame();
		jf.setSize(450, 500);
		jf.setVisible(true);
	}

}// end ServerPro class

class ServerFrame extends JFrame implements ActionListener {
	ServerSocket serverSocket = null;
	Socket socket = null;

	HashMap clients;

	JLabel info = new JLabel("�����Ͻ� ������ PORT�� �Է��ϼ���.");
	JLabel port = new JLabel("PORT");
	JTextField portField = new JTextField(3);
	JButton con = new JButton("�������� �ϱ�");
	JButton disCon = new JButton("�������� �ϱ�");
	List list = new List();
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();

	{
		top.setSize(450, 200);
		top.setLayout(new FlowLayout());
		top.add(info);
		top.add(port);
		top.add(portField);
		top.add(con);
		bottom.add(disCon);
		bottom.setSize(450, 200);
		con.addActionListener(this);
		disCon.addActionListener(this);
	}

	public ServerFrame() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);// ����ȭ ó��
		this.setLayout(new BorderLayout());
		this.add("North", top);
		this.add("Center", list);
		this.add("South", bottom);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == con) {
			int portNum = Integer.parseInt(portField.getText());
			start(portNum);
		} else if (obj == disCon) {
			System.exit(0);
		}

	}

	public void start(int port) {

		try {
			serverSocket = new ServerSocket(port);
			list.add("������ ���۵Ǿ����ϴ�.");
			Thread t1 = new StartThread();
			t1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // start()

	// Ŭ���̾�Ʈ�� �����͸� �Է��ϸ� ��� Ŭ���̾�Ʈ���� ������ ����
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
			}
		} // while
	} // sendToAll

	// ServerReceiver thread ȣ���ϴ� Ŭ����
	class StartThread extends Thread {
		public void run() {
			while (true) {
				try {
					socket = serverSocket.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				list.add("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���������Ͽ����ϴ�.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}
	}

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		// ������� Ŭ���̾�Ʈ�� �߰��� �� ���� �����
		public void run() {
			System.out.println(Thread.currentThread());
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "����");

				clients.put(name, out);
				list.add("���� ���������� ���� " + clients.size() + "�Դϴ�.");
				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// ignore
			} finally {
				sendToAll("#" + name + "���� �����̽��ϴ�.");
				clients.remove(name);
				list.add("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� ������ �����Ͽ����ϴ�.");
				list.add("���� ���������� ���� " + clients.size() + "�Դϴ�.");
			} // try
		} // run
	} // ReceiverThread
}