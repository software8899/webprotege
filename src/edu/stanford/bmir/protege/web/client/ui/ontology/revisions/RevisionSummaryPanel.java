package edu.stanford.bmir.protege.web.client.ui.ontology.revisions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import edu.stanford.bmir.protege.web.client.rpc.ProjectManagerService;
import edu.stanford.bmir.protege.web.client.rpc.ProjectManagerServiceAsync;
import edu.stanford.bmir.protege.web.client.rpc.data.*;
import edu.stanford.bmir.protege.web.client.ui.bioportal.upload.BioPortalUploadDialog;

import java.util.Date;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 07/10/2012
 */
public class RevisionSummaryPanel extends FlowPanel {

    public static final DateTimeFormat DATE_FORMAT = DateTimeFormat.getFormat("EEEE, d MMMM yyyy 'at' HH:mm:ss (zzzz)");

    private RevisionSummary revisionSummary;
    
    private ProjectId projectId;

    private UserData userData;

    public RevisionSummaryPanel(ProjectId projectId, UserData userData, RevisionSummary revisionSummary) {
        this.projectId = projectId;
        this.userData = userData;
        this.revisionSummary = revisionSummary;
        long revisionNumber = revisionSummary.getRevisionNumber().getValue();
        InlineLabel revisionNumberLabel = new InlineLabel("Revision: " + revisionNumber);
        revisionNumberLabel.addStyleName("webprotege-revision-summary-revision-number-style");
        add(revisionNumberLabel);
        String encodedProjectName = projectId.getEncodedProjectName();
        add(new Anchor(" [Download]", "download?ontology=" + encodedProjectName + "&revision=" + revisionNumber));

        
        Date date = new Date(revisionSummary.getTimestamp());
        add(new Label(DATE_FORMAT.format(date)));


        Label userIdLabel = new InlineLabel(revisionSummary.getUserId().getUserName());
        userIdLabel.addStyleName("webprotege-revision-summary-userid-style");
        add(userIdLabel);



        add(new InlineLabel(" (" + revisionSummary.getChangeCount() + " changes)"));
        addStyleName("webprotege-revision-summary-style");
    }
    


    private void uploadToBioPortal(ProjectData projectData) {
        BioPortalUploadDialog dlg = new BioPortalUploadDialog(projectData, userData);
        dlg.show();
    }
}
