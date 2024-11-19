package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public interface ReportFactory
{
    ReportBody buildBody();
    ReportHeader buildHeader();
    ReportFooter buildFooter();
}

class JSONReportFactory implements ReportFactory
{
    public ReportBody buildBody() {
        return new JSONReportBody();
    }
    
    public ReportHeader buildHeader() {
        return new JSONReportHeader();
    }
    
    public ReportFooter buildFooter() {
        return new JSONReportFooter();
    }
}

class XMLReportFactory implements ReportFactory
{
    public ReportBody buildBody() {
        return new XMLReportBody();
    }
    
    public ReportHeader buildHeader() {
        return new XMLReportHeader();
    }
    
    public ReportFooter buildFooter() {
        return new XMLReportFooter();
    }
}
