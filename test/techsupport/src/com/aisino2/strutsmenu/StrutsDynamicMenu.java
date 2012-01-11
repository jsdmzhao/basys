package com.aisino2.strutsmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;
import net.sf.navigator.menu.PermissionsAdapter;

public class StrutsDynamicMenu {
	private MenuRepository repository = new MenuRepository();

	private String repositoryKey = "repository";

	private String permessionsKey = "permessions";

	private String bundleKey = "bundle";

	private PermissionsAdapter permessions;

	private ResourceBundle bundle;

	public String getBundleKey() {
		return bundleKey;
	}

	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}

	public String getPermessionKey() {
		return permessionsKey;
	}

	public void setPermessionKey(String permessionKey) {
		this.permessionsKey = permessionKey;
	}

	public String getRepositoryKey() {
		return repositoryKey;
	}

	public void setRepositoryKey(String repositoryKey) {
		this.repositoryKey = repositoryKey;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public void setBundle(String bundleKey, ResourceBundle bundle) {
		setBundle(bundle);
		setBundleKey(bundleKey);
	}

	public StrutsDynamicMenu() {

	}

	public PermissionsAdapter getPermession() {
		return permessions;
	}

	public void setPermession(PermissionsAdapter permession) {
		this.permessions = permession;
	}

	public void setPermession(String permessionKey,
			PermissionsAdapter permession) {
		setPermessionKey(permessionKey);
		setPermession(permession);
	}

	public MenuRepository getRepository() {
		return repository;
	}

	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}

	public void setRepository(String repositoryKey, MenuRepository repository) {
		setRepository(repository);
		setRepositoryKey(repositoryKey);
	}

	private void setDisplayers(ServletContext context) {
		MenuRepository defaultRepository = (MenuRepository) context
				.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
		repository.setDisplayers(defaultRepository.getDisplayers());
	}

	private List buildMenuComponent(List menuNodeList) {
		List menuComponentList = new ArrayList();
		if(menuNodeList==null||menuNodeList.size()==0)
			return menuComponentList;
		String [] index=new String [menuNodeList.size()];
		Map nodeMap = new HashMap();
		for (int i = 0; i < menuNodeList.size(); i++) {
			MenuNode mc = (MenuNode) menuNodeList.get(i);
			nodeMap.put(mc.getName(), mc);
			index[i]=mc.getName();
		}
		for (int i = 0; i < index.length; i++) {
			MenuNode menuNode = (MenuNode) nodeMap.get(index[i]);
			if (menuNode.getParentName() != null
					&& menuNode.getParentName().trim().length() > 0) {
				menuNode.setParent((MenuNode) nodeMap.get(menuNode
						.getParentName()));
			}
			
			menuComponentList.add(menuNode);
		}
		for (int i = 0; i < menuComponentList.size(); i++) {
			MenuNode menuNode = (MenuNode) menuComponentList.get(i);
		
			if (menuNode.getComponents().size() > 0) {
				
				menuNode.setLocation(null);
				menuNode.setTarget(null);
			}
		}
		return menuComponentList;
	}

	private void addMenuComponent(List menuComponentList,HttpServletRequest request) {
		if (menuComponentList != null && menuComponentList.size() > 0) {
			for (int i = 0; i < menuComponentList.size(); i++) {
				MenuComponent mc = (MenuComponent) menuComponentList.get(i);
//			
				repository.addMenu(mc);
			}
		}
	}

	/**
	 * private void buildMenuComponent(List menuNodeList) { for (int i = 0; i <
	 * menuNodeList.size(); i++) { MenuNode mn = (MenuNode) menuNodeList.get(i);
	 * MenuComponent mc = new MenuComponent(); mc.setName(mn.getName());
	 * mc.setTitle(mn.getTitle()); String parent = mn.getParentName(); if
	 * (parent != null&&parent.length()>0) { MenuComponent parentMenu =
	 * repository.getMenu(parent); if (parentMenu == null) { parentMenu = new
	 * MenuComponent(); parentMenu.setName(parent);
	 * repository.addMenu(parentMenu); } mc.setLocation(mn.getLocation());
	 * mc.setTarget(mn.getTarget()); mc.setParent(parentMenu); }
	 * repository.addMenu(mc); } }
	 */
	public void buildMenu(MenuComponentFactory menuComponentFactory,
			HttpServletRequest request) {
		setDisplayers(request.getSession().getServletContext());
		addMenuComponent(buildMenuComponent(menuComponentFactory
				.getMenuComponents()),request);
		// buildMenuComponent(menuComponentFactory.getMenuComponents());
		request.setAttribute(repositoryKey, repository);
		request.setAttribute(permessionsKey, permessions);
		request.setAttribute(bundleKey, bundle);
	}

}
