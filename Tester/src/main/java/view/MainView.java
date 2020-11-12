package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.spi.FileTypeDetector;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import impl.ImportExportJSON;
import model.Entity;
import type.TypeFile;

public class MainView extends JFrame {
	
	private static MainView instance = null;
	private JList<Entity> jList;
	private DefaultListModel<Entity> listModel;
	private List<Entity> list;
	private JButton updateBut= new JButton("Update");
	private JButton addButton = new JButton("Add");
	private JButton delButton = new  JButton("Delete");
	private JButton sortButton = new  JButton("Sort");
	private JButton searchButton = new JButton("Search");
	private JButton exportBut = new JButton("Export");
	private JPanel upper = new JPanel();
	private JPanel whole = new JPanel();
	private String filepath;
	private TypeFile typeF;
	
	
	private MainView(TypeFile t,String filePath) throws Exception {
		
		this.typeF = t;
		this.filepath = filePath;
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDialog();
				
			}
		});
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Entity enti = jList.getSelectedValue();
				list.remove(enti);
				listModel.removeElement(enti);
				if(typeF==TypeFile.JSON) {
					ImportExportJSON ie = new ImportExportJSON();
					try {
						ie.exportObjectToFile(list, filepath);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(typeF==TypeFile.YML) {
					
				}
				else {
					
				}
				
			}
		});
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SearchDialog();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		updateBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Entity enti = jList.getSelectedValue();
				try {
					new UpdateDialog(enti);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ImportExportJSON imp = new ImportExportJSON();
        list = imp.importFileToObject(filepath);
        listModel = new DefaultListModel<Entity>();
        listModel.addAll(list);
        jList = new JList<Entity>(listModel);
		upper.add(addButton);
		upper.add(updateBut);
		upper.add(delButton);
		upper.add(sortButton);
		upper.add(searchButton);
		upper.add(exportBut);
		upper.setLayout(new GridLayout(1,6));
		whole.add(upper,BorderLayout.NORTH);
		JScrollPane scr = new JScrollPane(jList);
		//scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		whole.add(scr,BorderLayout.CENTER);
		//JScrollPane s = new JScrollPane(whole);
		this.add(whole);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1700,400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public TypeFile getTypeF() {
		return typeF;
	}
	public String getFilepath() {
		return filepath;
	}
	public JList<Entity> getjList() {
		return jList;
	}
	public DefaultListModel<Entity> getListModel() {
		return listModel;
	}
	public List<Entity> getList() {
		return list;
	}
	
	public static MainView getInstance() {
		return instance;
	}
	
	public static MainView getInstance(TypeFile t,String filePath) throws Exception {
		if(instance == null) {
				instance = new MainView(t,filePath); 
		}
		return instance;
	}
	

}
