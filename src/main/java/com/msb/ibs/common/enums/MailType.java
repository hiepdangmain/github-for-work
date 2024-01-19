package com.msb.ibs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailType {
    TO_MSB("TO_MSB"),//send to TTV/KSV khi checker cuối cùng phê duyệt
    MSB_APPROVED_REJECT("MSB_APPROVED_REJECT"),//send to Maker/checker khi MSB từ chối
    TO_MAKER_CHECKER("TO_MAKER_CHECKER"); // send mail thong bao lenh CKNG, SUCC, FAIL cho maker, checker
    private final String value;
}
