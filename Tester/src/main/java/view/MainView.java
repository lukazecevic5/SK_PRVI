package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	
	
	private MainView() throws Exception {
		
		
		
		ImportExportJSON imp = new ImportExportJSON();
        list = imp.importFileToObject("data/data.json");
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
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		whole.add(scr,BorderLayout.CENTER);
		this.add(whole);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(new Dimension(1500,400));
		this.setVisible(true);
		
	}
	
	public List<Entity> getList() {
		return list;
	}
	
	public static MainView getInstance() throws Exception {
		if(instance == null) {
				instance = new MainView(); 
		}
		return instance;
	}
	

}
