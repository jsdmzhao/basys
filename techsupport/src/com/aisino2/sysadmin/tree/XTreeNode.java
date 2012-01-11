package com.aisino2.sysadmin.tree;

import com.aisino2.core.xml.XMLElement;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.System;

public class XTreeNode {
  private XMLElement xmlElement;

  public XTreeNode(XMLElement xmlElement) {
    this.xmlElement = xmlElement;
  }

  public XTreeNode addChildDepart(Department department) {
    return addChildNode(Integer.toString(department.getDepartid()),
                        department.getDepartname());
  }

  public XTreeNode addChildMenu(Menu menu) {
    return addChildNode(menu.getMenucode(), menu.getMenuname());
  }

  public XTreeNode addChildSystem(System system) {
    return addChildNode(system.getSystemcode(), system.getSystemname());
  }

  private XTreeNode addChildNode(String id, String text) {
    XMLElement childElement = xmlElement.addChildElement("item");
    childElement.addAttribute("id", id);
    childElement.addAttribute("text", text);
    childElement.addAttribute("im0", "leaf.gif");
    childElement.addAttribute("im1", "folderOpen.gif");
    childElement.addAttribute("im2", "folderClosed.gif");
    return new XTreeNode(childElement);
  }

  public String getXML() {
    return xmlElement.getXML();
  }
}
