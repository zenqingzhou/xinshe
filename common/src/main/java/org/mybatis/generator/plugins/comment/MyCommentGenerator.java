package org.mybatis.generator.plugins.comment;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Properties;
import java.util.Set;

public class MyCommentGenerator implements CommentGenerator {
	@Override
	public void addConfigurationProperties(Properties properties) {

	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
	    if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
	        field.addJavaDocLine("/**");
	        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
	       // addJavadocTag(field, false);
	        field.addJavaDocLine(" */");
	    }
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

	}

//	@Override
//	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//
//	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {

	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {

	}

	@Override
	public void addComment(XmlElement xmlElement) {

	}

	@Override
	public void addRootComment(XmlElement xmlElement) {

	}

//	@Override
//	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
//
//	}
//
//	@Override
//	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
//
//	}
//
//	@Override
//	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
//
//	}
//
//	@Override
//	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
//
//	}
//
//	@Override
//	public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
//
//	}

//
//	public void addConfigurationProperties(Properties properties) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addFieldComment(Field field,
//			IntrospectedTable introspectedTable,
//			IntrospectedColumn introspectedColumn) {
//		// TODO Auto-generated method stub
//	    if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
//	        field.addJavaDocLine("/**");
//	        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
//	       // addJavadocTag(field, false);
//	        field.addJavaDocLine(" */");
//	    }
//	}
//
//
//	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
//		// TODO Auto-generated method stub
//
//
//	}
//
//
//	public void addClassComment(InnerClass innerClass,
//			IntrospectedTable introspectedTable) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addClassComment(InnerClass innerClass,
//                                IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addEnumComment(InnerEnum innerEnum,
//			IntrospectedTable introspectedTable) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addGetterComment(Method method,
//			IntrospectedTable introspectedTable,
//			IntrospectedColumn introspectedColumn) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addSetterComment(Method method,
//			IntrospectedTable introspectedTable,
//			IntrospectedColumn introspectedColumn) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addGeneralMethodComment(Method method,
//			IntrospectedTable introspectedTable) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addJavaFileComment(CompilationUnit compilationUnit) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addComment(XmlElement xmlElement) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void addRootComment(XmlElement rootElement) {
//		// TODO Auto-generated method stub
//
//	}
//
}
