package com.apex.doc.popup.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
//import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
//import org.eclipse.swt.layout.FormData;
//import org.eclipse.swt.widgets.DirectoryDialog;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.jdt.core.IJavaElement;

public class AppStart implements IObjectActionDelegate {
	private IStructuredSelection select;
    public String path;

//	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public AppStart() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	//	shell = targetPart.getSite().getShell();
		
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		Object obj = null;
        try
        {
        	obj = select.getFirstElement();
            IResource file = (IResource) obj;  
            path = file.getLocation().toOSString();
            System.out.println("assssssss" + path);
        }
        catch (ClassCastException e)
        {
        	try
            {
                IJavaElement element = (IJavaElement) obj;               
                path = element.getResource().getLocation().toOSString();
                System.out.println("ffff" + path);
            }
        	catch(Exception ef){}
        	e.printStackTrace();
        }
		try{
		ApexDocForm simpleForm = new ApexDocForm(null, path);
	    simpleForm.setBlockOnOpen(true);
	    //simpleForm.setStatus("hhhhhhh");
	    
	    simpleForm.open();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection)
        {
            select = (IStructuredSelection) selection;
        }

	}

}
