import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

class GlobalVals{
	
	static File arquivo = null;
	
}

public class View {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label txtPrimeiroTitulo = new Label("Arquivo");
		txtPrimeiroTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPrimeiroTitulo.setBounds(30, 10, 60, 28);
		frame.getContentPane().add(txtPrimeiroTitulo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		panel.setBounds(25, 22, 387, 90);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel txtNomeArquivo = new JLabel("");
		txtNomeArquivo.setBounds(145, 36, 184, 22);
		panel.add(txtNomeArquivo);
		

		Button button = new Button("Escolher arquivo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if(i == 1) {
					txtNomeArquivo.setText("");
				}else {
					GlobalVals.arquivo = file.getSelectedFile();
					if(GlobalVals.arquivo.getName().endsWith(".embl")) {
						txtNomeArquivo.setText(GlobalVals.arquivo.getName());
						
					}else {
						JOptionPane.showMessageDialog(null, "Insira um arquivo no formato .embl");
					}
				}
			}
		});
		button.setForeground(SystemColor.windowText);
		button.setBackground(SystemColor.inactiveCaption);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(10, 27, 114, 31);
		panel.add(button);
		
		Label txtSegundoTitulo = new Label("Op\u00E7\u00F5es de contagem");
		txtSegundoTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSegundoTitulo.setBounds(28, 119, 154, 22);
		frame.getContentPane().add(txtSegundoTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption));
		panel_1.setBounds(25, 131, 387, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<String> seletorOpcao = new JComboBox<>();
		seletorOpcao.setModel(new DefaultComboBoxModel<String>(new String[] {"Quantidade CDS ", "Quantidade Produtos", "Quantidade de produtos com a sigla gene", "Quantidade de tRNA", "Quantidade de rRNA"}));
		seletorOpcao.setBounds(30, 23, 257, 22);
		panel_1.add(seletorOpcao);
		
		JButton botaoStart = new JButton("In\u00EDcio");
		botaoStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Embl resultado = new Embl(GlobalVals.arquivo.getAbsolutePath());
					
					switch (seletorOpcao.getSelectedIndex()) {
						case 0:
							resultado.quantidadeCDS();
							break;
						case 3:
							resultado.quantidadeTRNA();
							break;
						case 4:
							resultado.quantidadeRRNA();
							break;
					}
					

				//JOptionPane.showMessageDialog(null,"Local Arquivo: " + GlobalVals.arquivo.getAbsolutePath() +"\nIndex: " + seletorOpcao.getSelectedIndex());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Insira um arquivo!");
				}
			}
		});
		botaoStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoStart.setBounds(316, 222, 96, 28);
		frame.getContentPane().add(botaoStart);
	}
}
