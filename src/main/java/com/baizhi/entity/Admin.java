package com.baizhi.entity;

public class Admin
{
  private String id;
  private String username;
  private String password;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public Admin() {}
  
  public Admin(String id, String username, String password)
  {
    this.id = id;
    this.username = username;
    this.password = password;
  }
  
  
  public String toString()
  {
    return 
      "Admin [id=" + this.id + ", username=" + this.username + ", password=" + this.password + "]";
  }
}
