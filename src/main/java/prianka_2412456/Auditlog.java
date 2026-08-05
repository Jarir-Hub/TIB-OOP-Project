package prianka_2412456;

import java.time.LocalDate;

public class Auditlog {

    int logid;
    String username;
    LocalDate timestamp;
    int ipAddress;
    boolean sucessStatus;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(Integer ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isSucessStatus() {
        return sucessStatus;
    }

    public void setSucessStatus(boolean sucessStatus) {
        this.sucessStatus = sucessStatus;
    }

    public boolean validateDateRange(){
       return false;
    }
}
