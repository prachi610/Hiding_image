import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class imagehide {
	public static void main(String[] agrs) {
		JFrame jf = new JFrame();
		jf.setTitle("Image Operation");	
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		JLabel l = new JLabel("You can hide your image through this.");
		JLabel ll = new JLabel("Enter a key:");
		jf.add(l);
		jf.add(ll);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Creating Button
		Font font = new Font("Roboto", Font.BOLD, 25);
		JButton btn = new JButton();
		btn.setText("Open Image");
		btn.setFont(font);
		
		
		//Creating text field
		JTextField jtf = new JTextField(10);
		jtf.setFont(font);
		
		jf.setLayout(new FlowLayout());
		jf.add(btn);
		jf.add(jtf);
		
		
		btn.addActionListener(e->{
			String text = jtf.getText();
			int temp = Integer.parseInt(text);
			operate(temp);
		});
		jf.setVisible(true);
		
		
	}

	public static void operate(int temp) {
		
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();
		
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			int k = 0;
			for(byte i: b) {
//				System.out.println(b);
				b[k] = (byte) (i^temp); 
				k++;
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(b);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
