package com.aisino2.sysadmin.tree;

import com.aisino2.core.xml.XMLDocument;
import com.aisino2.core.xml.XMLElement;

public class XTree {
  private XMLDocument xmlDocument;
  private String treeID;

  public XTree(String treeID) {
    xmlDocument = new XMLDocument();
    this.treeID = treeID;
  }

  public XTreeNode getRootNode() {
    XMLElement xmlElement = xmlDocument.addRootElement("item");
    xmlElement.addAttribute("id", treeID);
    return new XTreeNode(xmlElement);
  }

  public String getXML() {
    return xmlDocument.getXML();
  }

  public String getXML(String encoding) {
    return xmlDocument.getXML(encoding);
  }
}
