package common.credit.dubbo;


import common.credit.format.Document;
import common.credit.format.DocumentInput;

public interface CreditBankLoanService {

    /*
     * 初审通知请求，网商银行-银行机构
     */
    public Document applyNotify(DocumentInput document);

    /*
     * 初审数据上传，银行机构-网商银行
     */
    public Document approveUpload(DocumentInput document);
    /*
     * 终审通知，网商银行-银行机构
     */
    public Document finalNotify(DocumentInput document);

    /*
     * 终审确认，银行机构-网商银行
     */
    public Document finalConfirm(DocumentInput document);

}
