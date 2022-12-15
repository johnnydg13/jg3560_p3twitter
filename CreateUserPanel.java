package jgProjectMiniTwitter;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CreateUserPanel extends MiniTwitterApp {
	
	 private static final long serialVersionUID = 1L;
	 private JPanel treePanel;
	 private Map<String, Observer> allUsers;

	 private JButton addUserButton;
	 private JButton addGroupButton;
	 private JButton clearAllButton;
	 
	 private JTextField userId;
	 private JTextField groupId;
	 private int duplicates;
	 
	 private JButton lastUpdateButton;
	 
	 

		private JButton validateButton;

	/**
	 * Create the panel.
	 */
	protected CreateUserPanel(JPanel treePanel, Map<String, Observer> allUsers) 
	{
		
		super();
	    this.treePanel = treePanel;
	    this.allUsers = allUsers;
	    this.duplicates = 0;

	    initComponents();
	    addComponents();
	}

	

	 protected void addComponents() 
	 {
		 addComponent(this, userId, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	     addComponent(this, addUserButton, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	     addComponent(this, groupId, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	     addComponent(this, addGroupButton, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	     addComponent(this, clearAllButton, 0, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	
	        addComponent(this, validateButton, 0, 3, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	   
	        addComponent(this, lastUpdateButton, 1, 4, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	        
	     
	 }

	 protected void initComponents() 
	 {
	     userId = new JTextField("User ID");
	     groupId = new JTextField("Group ID");

	     addUserButton = new JButton("Add User");
	     initializeAddUserButtonActionListener();

	     addGroupButton = new JButton("Add Group");
	     initializeAddGroupButtonActionListener();
	        
	     clearAllButton = new JButton("Delet All Users");
	     initializeClearAllButtonActionListener();
	     
	   
	        validateButton = new JButton("Validate?");
	        initializeValidateButtonActionListener();
	      
	        lastUpdateButton = new JButton("Latest Update");
	        initializeLastUpdateButtonActionListener();
	        

	        
	 }

	
	protected void initializeAddUserButtonActionListener() 
	{
	     addUserButton.addActionListener(new ActionListener() {

	     @Override
		public void actionPerformed(ActionEvent arg0) 
	     {
	   
	         if (allUsers.containsKey(userId.getText())) 
	         {
	        	 InfoDialogBox dialogBox = new InfoDialogBox("Error:",
	                            "User already exists!",
	                            JOptionPane.ERROR_MESSAGE);
	        	 
	             Observer child = new SingleUser(userId.getText());
	             

	             allUsers.put(((User) child).getID(), child);
	             ((TreePanel) treePanel).addSingleUser((DefaultMutableTreeNode) child);
	             
	             ((User) child).setCreationTime();
	             
	             System.out.println(((User) child).getID() + " created on " + ((User) child).getCreationTime());
	             ((User) child).setUniqueFalse();
	             ((User)child).getUnique();
	             duplicates++;
	        	 
	         } 
	         else 
	         {
	             Observer child = new SingleUser(userId.getText());

	             allUsers.put(((User) child).getID(), child);
	             ((TreePanel) treePanel).addSingleUser((DefaultMutableTreeNode) child);
	             
	             ((User) child).setCreationTime();
	             
	             System.out.println(((User) child).getID() + " created on " + ((User) child).getCreationTime());
	             ((User) child).setUniqueTrue();
	             ((User)child).getUnique();
	             
	            
	         }
	      }
	     
	    });
	 }

	
	 protected void initializeAddGroupButtonActionListener() 
	 {
	        addGroupButton.addActionListener(new ActionListener() 
	        {

	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	              
	                if (allUsers.containsKey(groupId.getText())) 
	                {        
	                    InfoDialogBox dialogBox = new InfoDialogBox("Error:",
	                            "Group already exists.",
	                            JOptionPane.ERROR_MESSAGE);
	                    
	                    Observer child = new GroupUser(groupId.getText());

	                    allUsers.put(((User) child).getID(), child);
	                    ((TreePanel) treePanel).addGroupUser((DefaultMutableTreeNode) child);
	                    
	                    ((User) child).setCreationTime();
	   	             
	   	             System.out.println(((User) child).getID() + " created on " + ((User) child).getCreationTime());
	   	             ((User) child).setUniqueFalse();
	   	             ((User)child).getUnique();
	   	             duplicates++;
	                   
	                } 
	                else 
	                {
	                    Observer child = new GroupUser(groupId.getText());

	                    allUsers.put(((User) child).getID(), child);
	                    ((TreePanel) treePanel).addGroupUser((DefaultMutableTreeNode) child);
	                    
	                    ((User) child).setCreationTime();
	   	             
	   	             System.out.println(((User) child).getID() + " created on " + ((User) child).getCreationTime());
	   	             ((User) child).setUniqueTrue();
	   	             ((User)child).getUnique();
	                }
	            }
	        });
	    }
	    
	


	    protected void initializeClearAllButtonActionListener() 
	    {
	        clearAllButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	                
	            	allUsers.clear();
	            	InfoDialogBox dialogBox = new InfoDialogBox("Attention:",
                            "All Users Cleared!",
                            JOptionPane.ERROR_MESSAGE);
	            	
	            }
	        });
	    }

	  
	    protected void initializeValidateButtonActionListener() 
			{
			     validateButton.addActionListener(new ActionListener() 
			     {
			    	

			    	@Override
					public void actionPerformed(ActionEvent arg0) 
					{
			   
		            if(duplicates > 0)
			    	
		            {
		       		 InfoDialogBox dialogBox = new InfoDialogBox("Validation:",
	                         "Invalid, IDs can not be duplicates!",
	                         JOptionPane.ERROR_MESSAGE); 
		            }
		          
		            else if(allUsers.containsKey(" "))
		            {
		       		 InfoDialogBox dialogBox = new InfoDialogBox("Validation:",
	                         "Invalid, IDs can not contain spaces!",
	                         JOptionPane.ERROR_MESSAGE); 
		            }
		          
		            else if(duplicates == 0)
		            {
		            	
		            	 

		       		 InfoDialogBox dialogBox = new InfoDialogBox("Validation:",
	                         "Valid IDs!",
	                         JOptionPane.ERROR_MESSAGE); 
		            }	     
					}
			    });
			 }

	    protected DefaultMutableTreeNode getSelectedNode() {
	        JTree tree = ((TreePanel) treePanel).getTree();
	        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
	        if (!((TreePanel) treePanel).getRoot().equals(selectedNode)) {
	            selectedNode = (DefaultMutableTreeNode) selectedNode.getUserObject();
	        }

	        return selectedNode;
	    }
	    
	    
	    protected void initializeLastUpdateButtonActionListener() 
	    {
	        lastUpdateButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	                
	            	
				
					InfoDialogBox dialogBox = new InfoDialogBox("Latest Update:",
							" ",
	                        JOptionPane.INFORMATION_MESSAGE);
	            	
	            }
	        });
	    }
	    
	    
	

}
