/*
 * Generated by XDoclet - Do not edit!
 */
package com.mockrunner.example.ejb.interfaces;

/**
 * Home interface for UserEntity.
 */
public interface UserEntityHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/UserEntity";
   public static final String JNDI_NAME="com/mockrunner/example/UserEntity";

   public com.mockrunner.example.ejb.interfaces.UserEntity create(java.lang.String username , java.lang.String password)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public com.mockrunner.example.ejb.interfaces.UserEntity findByPrimaryKey(java.lang.String username)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
