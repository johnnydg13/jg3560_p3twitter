package jgProjectMiniTwitter;

import java.time.LocalDateTime;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class User extends DefaultMutableTreeNode implements Observer {
	
	  private static final long serialVersionUID = 1L;
	  private String id;
	  private int messageCount;
	  public abstract boolean contains(String id);
	  public abstract int getSingleUserCount();
	  public abstract int getGroupUserCount();
	  private boolean unique;
	  private LocalDateTime creationTime;
	  
	  
	  

	  protected User(String id) {
	        super(id);
	        this.id = id;
	        this.setMessageCount(0);
	        this.creationTime = null;
	        
	        
	       
	  }

	  
	  protected String getID() {
	        return id;
	  }
	  
	  protected void setUniqueTrue() {
		  this.unique = true;
	  }
	  
	  protected void setUniqueFalse() {
		  this.unique = false;
	  }
	  
	  protected boolean getUnique() {
		  System.out.println(unique);
		  return unique;
	  }

	  protected int getMessageCount() {
	        return messageCount;
	  }

	  protected void setMessageCount(int messageCount) {
	        this.messageCount = messageCount;
	  }


	  protected abstract void accept(Visitor visitor);
	
	  protected void setCreationTime() {
		  creationTime = java.time.LocalDateTime.now(); 
	  }
	  
	  
	  public LocalDateTime getCreationTime() {
		  //System.out.println(creationTime);
		  
	      return this.creationTime;
	  }


	  
	
	

}
