package com.apex.doc.popup.actions;
//import java.awt.Color;
//import java.io.File;
//import java.util.ArrayList;

//import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.window.ApplicationWindow;
//import java.awt.Desktop;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
//import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Menu;
//import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
//import org.eclipse.ui.forms.widgets.Section;
//import org.eclipse.ui.forms.widgets.TableWrapData;

import apex.com.main.ApexDoc;
//import apex.com.main.ClassModel;
//import apex.com.main.FileManager;

public class ApexDocForm extends ApplicationWindow {
  private String path;
  /**
   * @param parentShell
   */
  public ApexDocForm(Shell parentShell, String path) {
	  super(parentShell);
	  super.setShellStyle(SWT.MIN);
	  this.path = path;
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)
   */
  protected Control createContents(Composite parent) {
    final Composite composite = new Composite(parent, SWT.APPLICATION_MODAL);
    composite.setLayout(new GridLayout());
    // Sets up the toolkit.
    FormToolkit toolkit = new FormToolkit(getShell().getDisplay());
    
    // create a form instance.
    org.eclipse.swt.graphics.Color bg = new org.eclipse.swt.graphics.Color(null,236,233,216);
    final Form form = toolkit.createForm(composite);
    form.setLayoutData(new GridData(GridData.FILL_BOTH));
    form.setBackground(new org.eclipse.swt.graphics.Color(null,236,233,216));
    form.setForeground(new org.eclipse.swt.graphics.Color(null,0,0,0));
    form.setFont(new Font(null,"",12, 1));
    //form.setText("Force.com Documentation Tool");
    Image lookImage = new Image(form.getShell().getDisplay(), this.getClass().getResourceAsStream(
    "apex_doc_logo.png"));
    
   
    
    CLabel l = new CLabel(form.getBody(), SWT.LEFT);
    l.setFont(new Font(null,"",12, 1));
    l.setText("Force.com Apex Documentation Tool\n\n version 1.1.1");
    l.setImage(lookImage);
    GridData gd1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
    gd1.horizontalSpan = 3;
    l.setLayoutData(gd1);
    //l.setAlignment(CLabel);
      
    //Image image = new Image(form.getShell().getDisplay(), "apex_doc_logo.png");
    //Label imageLabel = new Label(form.getShell(), SWT.NONE);
    //imageLabel.setImage(image);
    //form.setImage(image);
    createLine(form, 3);
    form.getBody().setLayout(new GridLayout(3, false));
    
    /*
    Label img = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    img.setImage(lookImage);
    img.setBackground(bg);
    
    Label img2 = toolkit.createLabel(form.getBody(), "ApexDoc - Force.com Documentation Tool", SWT.NULL);
    img2.setBackground(bg);
    
    Label lll = toolkit.createLabel(form.getBody(), "    ", SWT.NULL);
    lll.setBackground(bg);
    */
    Label label = toolkit.createLabel(form.getBody(), "Source Directory ", SWT.NULL);
    label.setBackground(bg);
    final Text textSD = toolkit.createText(form.getBody(), path);
    textSD.setEditable(false);
    textSD.setEnabled(false);
    textSD.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    Label ll = toolkit.createLabel(form.getBody(), "    ", SWT.NULL);
    ll.setBackground(bg);
    //Button buttonSD = toolkit.createButton(form.getBody(), "...", SWT.PUSH);
    //buttonSD.setLayoutData(new GridData(GridData.END));
    label = toolkit.createLabel(form.getBody(), "Target Directory ", SWT.NULL);
    label.setBackground(bg);
    final Text textTD = toolkit.createText(form.getBody(), "");
    textTD.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    Button buttonTD = toolkit.createButton(form.getBody(), "...", SWT.PUSH);
    buttonTD.setLayoutData(new GridData(GridData.END));
    
    label = toolkit.createLabel(form.getBody(), "Home HTML File ", SWT.NULL);
    label.setBackground(bg);
    final Text textHtml = toolkit.createText(form.getBody(), "");
    textHtml.setLayoutData(new GridData(GridData.FILL_BOTH));
    Button buttonHF = toolkit.createButton(form.getBody(), "...", SWT.PUSH);
    buttonHF.setLayoutData(new GridData(GridData.END));
    
    label = toolkit.createLabel(form.getBody(), "Author File ", SWT.NULL);
    label.setBackground(bg);
    final Text  textAuthor = toolkit.createText(form.getBody(), "");
    textAuthor.setLayoutData(new GridData(GridData.FILL_BOTH));
    Button buttonAF = toolkit.createButton(form.getBody(), "...", SWT.PUSH);
    buttonAF.setLayoutData(new GridData(GridData.END));


    label = toolkit.createLabel(form.getBody(), "Scope to document ", SWT.NULL);
    label.setBackground(bg);
    GridData gd = new GridData(GridData.BEGINNING);
    gd.horizontalSpan = 2;
    final Button cbxGlobal = toolkit.createButton(form.getBody(), "global", SWT.CHECK);
    cbxGlobal.setSelection(true);
    cbxGlobal.setBackground(bg);
    cbxGlobal.setLayoutData(gd);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label.setBackground(bg);
    final Button cbxPublic = toolkit.createButton(form.getBody(), "public", SWT.CHECK);
    cbxPublic.setSelection(true);
    cbxPublic.setBackground(bg);
    cbxPublic.setLayoutData(gd);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label.setBackground(bg);
    final Button cbxPrivate = toolkit.createButton(form.getBody(), "private", SWT.CHECK);
    cbxPrivate.setBackground(bg);
    cbxPrivate.setLayoutData(gd);
  
    Button buttonClose = toolkit.createButton(form.getBody(), " Close ", SWT.PUSH);
    Button buttonGenerate = toolkit.createButton(form.getBody(), " Generate ", SWT.PUSH);
    buttonClose.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
    buttonGenerate.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
    //label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
    
    //create some space (there must be a better way!)
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    
    FormText formText = toolkit.createFormText(form.getBody(), true);
    gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
    gd.horizontalSpan = 3;
    formText.setLayoutData(gd);
    String text = "For more info about ApexDoc, visit the Google code project at http://code.google.com/p/apexdoc/ ";
    formText.setText(text, false, true);
    formText.setBackground(bg);
    
    //create some space (there must be a better way!)
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    label = toolkit.createLabel(form.getBody(), "", SWT.NULL);
    
    buttonTD.addSelectionListener(new SelectionListener() {

        public void widgetSelected(SelectionEvent event) {
        	DirectoryDialog dialog = new DirectoryDialog(form.getShell());
            dialog.setFilterPath("c:\\"); // Windows specific
            textTD.setText(dialog.open());
            
        }

        public void widgetDefaultSelected(SelectionEvent event) {
        	
        }
      });
    
    
    buttonHF.addSelectionListener(new SelectionListener() {

        public void widgetSelected(SelectionEvent event) {
        	FileDialog dialog = new FileDialog(form.getShell(), SWT.SAVE);
            dialog
                .setFilterNames(new String[] { "HTML Files"});
            dialog.setFilterExtensions(new String[] { "*.html"}); // Windows
                                            // wild
                                            // cards
            //dialog.setFilterPath("c:\\"); // Windows path
            dialog.setFileName("samplehome.html");
            textHtml.setText(dialog.open());
        }

        public void widgetDefaultSelected(SelectionEvent event) {
        	
        }
      });
    
    buttonAF.addSelectionListener(new SelectionListener() {

        public void widgetSelected(SelectionEvent event) {
        	FileDialog dialog = new FileDialog(form.getShell(), SWT.SAVE);
            dialog
                .setFilterNames(new String[] { "Text Files"});
            dialog.setFilterExtensions(new String[] { "*.txt"}); // Windows
                                            // wild
                                            // cards
            //dialog.setFilterPath("c:\\"); // Windows path
            dialog.setFileName("author.txt");
            textAuthor.setText(dialog.open());
        }

        public void widgetDefaultSelected(SelectionEvent event) {
        	
        }
      });
  
    buttonClose.addSelectionListener(new SelectionListener() {

        public void widgetSelected(SelectionEvent event) {
        	form.getShell().dispose();
        }

        public void widgetDefaultSelected(SelectionEvent event) {
        	
        }
      });
    
    buttonGenerate.addSelectionListener(new SelectionListener() {

        public void widgetSelected(SelectionEvent event) {
        	try{
	        	String[] rgstrArgs = new String[10];
	        	String tD = textTD.getText();
	        	String sD = textSD.getText();
	        	String hFile = textHtml.getText();
	        	String aFile = textAuthor.getText();
	        	
	        	int i = 0;
	        	if (tD != null) {
	        		rgstrArgs[i++] = "-t";
	        		rgstrArgs[i++] = tD;
	        	}
	        	if (sD != null) {
	        		rgstrArgs[i++] = "-s";
	        		rgstrArgs[i++] = sD;
	        	}
	        	if (hFile != null) {
	        		rgstrArgs[i++] = "-h";
	        		rgstrArgs[i++] = hFile;
	        	}
	        	if (aFile != null) {
	        		rgstrArgs[i++] = "-a";
	        		rgstrArgs[i++] = aFile;
	        	}
	        	
	        	String strScope = null;
	        	if (cbxGlobal.getSelection()) {
	        		strScope = "global;";
	        	}
	        	if (cbxPublic.getSelection()) {
	        		strScope += "public;";
	        	}
	        	if (cbxPrivate.getSelection()) {
	        		strScope += "private";
	        	}
	        	if (strScope != null) {
	        		rgstrArgs[i++] = "-p";
	        		rgstrArgs[i++] = strScope;
	        	}
	        	       		        	
	        	//ApexDoc.RunApexDoc(rgstrArgs);
	        	ApexDoc.rgstrArgs = rgstrArgs;
	        	new ProgressMonitorDialog(form.getShell()).run(true, false, new ApexDoc()); 
	        	
				//ApexDoc.fm.infoMessages.append(".................................\n");
				//ApexDoc.fm.infoMessages.append("DONE");
	        	String str = "ApexDoc has completed successfully.\n" + "The location of the documentation home page is: \n";
	        	str += tD + "\\ApexDocumentation\\index.html\n\n";
	        	str += "Would you like to open it now?";
				if (MessageDialog.openQuestion(form.getShell(), "ApexDoc Generation Results", str)) {						
					// open a browser
					String strUrl = "file:///" + tD + "/ApexDocumentation/index.html";
					strUrl = strUrl.replaceAll(" ", "%20");
					strUrl = strUrl.replace('\\', '/');
					java.net.URI uri = new java.net.URI(strUrl);
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					desktop.browse(uri);
				}
				
				// close the dialog.
				form.getShell().dispose();
        	} catch (Exception ex) {
        		ex.printStackTrace();
    			MessageDialog.openError(form.getShell(), "ApexDoc Error", ex.getMessage());
        	}        	        	
        }

        public void widgetDefaultSelected(SelectionEvent event) {
        	
        }
      });
    
    return composite;
  }
  private void createLine(Composite parent, int ncol) {
	    Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL
	        | SWT.BOLD);
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
	    gridData.horizontalSpan = ncol;
	    line.setLayoutData(gridData);
	  }
}