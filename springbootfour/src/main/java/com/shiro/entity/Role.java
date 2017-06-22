package com.shiro.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer rid;

    private String rname;
    
    private Set<User> users=new HashSet<>();
    
    private Set<Module> modules=new HashSet<>();
    
    

    public Set<Module> getModules() {
	
		return modules;
	}

	public void setModules(Set<Module> modules) {
	
		this.modules = modules;
	}

	public Set<User> getUsers() {
	
		return users;
	}

	public void setUsers(Set<User> users) {
	
		this.users = users;
	}
	

	public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}