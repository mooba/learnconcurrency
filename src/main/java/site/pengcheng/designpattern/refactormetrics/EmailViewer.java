package site.pengcheng.designpattern.refactormetrics;

import site.pengcheng.designpattern.metrics.EmailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/11 6:38 下午
 */
public class EmailViewer implements StatsViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(EmailSender emailSender, List<String> toAddresses) {
        this.emailSender = emailSender;
        this.toAddresses = toAddresses;
    }

    public EmailViewer(List<String> toAddresses) {
        this.toAddresses.addAll(toAddresses);
    }

    @Override
    public void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis) {
        for (String address: toAddresses) {
            emailSender.send(address);
        }
    }

    public void addToAddresses(String address) {
        this.toAddresses.add(address);
    }
}
