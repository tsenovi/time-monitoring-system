package protocol;

import authentication.PublicAccount;
import parse.DateParser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Protocol implements Serializable {

    private final Date protocolDate;
    private final int weekNum;
    private final PublicAccount employee;
    private final List<Pair> workingTimesPerClient;

    public Protocol(Date protocolDate, PublicAccount employee, List<Pair> workingTimesPerClient) {
        this.protocolDate = protocolDate;
        weekNum = DateParser.parseWeekNumber(protocolDate);
        this.employee = employee;
        this.workingTimesPerClient = workingTimesPerClient;

    }


    public Date getProtocolDate() {
        return protocolDate;
    }

    public PublicAccount getEmployee() {
        return employee;
    }

    public List<Pair> getWorkingTimesPerClient() {
        return workingTimesPerClient;
    }

    @Override
    public String toString() {
        return "Protocol{" +
               "protocolDate=" + protocolDate +
               ", employee=" + employee +
               ", workingTimesPerClient=" + workingTimesPerClient +
               '}';
    }

    public int getWeekNum() {
        return weekNum;
    }
}
