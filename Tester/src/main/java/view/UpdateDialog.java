package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import impl.ImportExportJSON;
import model.Entity;
import type.TypeFile;

public class UpdateDialog extends JDialog {
	public UpdateDialog(Entity entity) throws Exception {
		JLabel idLbl = new JLabel("ID"),nazivLbl = new JLabel("Naziv"),atributiLbl =new JLabel("Atributi"),ugLbl = new JLabel("ugnjezdeni");
		JTextField idTxt = new JTextField(Integer.toString(entity.getId())),nazivTxt = new JTextField(entity.getNaziv());
		StringBuilder sb = new StringBuilder();
		Iterator it = entity.getSimpleProperties().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sb.append(pair.getKey().toString());
            sb.append("-");
            sb.append(pair.getValue().toString());
            sb.append("-\n");
        }
		String res = sb.toString();
		res = res.substring(0, res.length()-2);
		JTextArea atributText = new JTextArea(res);
		
		
		JButton update = new JButton("Update");
		MainView.getInstance().getList().remove(entity);
		MainView.getInstance().getListModel().removeElement(entity);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=0;
				try {
					 Map<String, String> simpleProperties = new HashMap<String, String>();
					 if(idTxt.getText().isEmpty()) {
						boolean i = true;
						while(i) {
							Random rand = new Random();
							int r = rand.nextInt(101);
							boolean j = false;
							for (Entity en : MainView.getInstance().getList()) {
								if(en.getId()==r) {
									j = true;
									break;
								}
							}
							if(j) {
								continue;
							}
							else {
								i = false;
								id = r;
							}
						}
					 }
					 else
						 id = Integer.parseInt(idTxt.getText());
					 String naziv = nazivTxt.getText();
					 String[] str =  atributText.getText().split("-");
					 for(int i =0;i<str.length;i+=2) {
						 //String res = str[i+1].substring(0, str[i+1].length());
						 simpleProperties.put(str[i], str[i+1]);
					 }
					 for (Entity en : MainView.getInstance().getList()) {
						if(en.getId()==id) {
							JDialog warning = new JDialog();
							JLabel idTaken = new JLabel("ID VEC ISKORISCEN");
							warning.add(idTaken);
							warning.setSize(new Dimension(200, 200));
							warning.setLocationRelativeTo(null);
							warning.setVisible(true);
							return;
						}
					}
					Entity ent = new Entity(id, naziv);
					ent.setSimpleProperties(simpleProperties);
					MainView.getInstance().getList().add(ent);
					TypeFile tf= MainView.getInstance().getTypeF();
					if(tf==TypeFile.JSON) {
						ImportExportJSON ie = new ImportExportJSON();
						ie.exportObjectToFile(MainView.getInstance().getList(), MainView.getInstance().getFilepath());
					}
					else if(tf==TypeFile.YML) {
						
					}
					else {
						
					}
					MainView.getInstance().getListModel().addElement(ent);
					
					dispose();
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
			}
		});
		
		add(idLbl);
		add(idTxt);
		add(nazivLbl);
		add(nazivTxt);
		add(atributiLbl);
		add(atributText);
		
		add(update);
		setLayout(new GridLayout(4,2));
		setSize(new Dimension(1600, 1000));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
