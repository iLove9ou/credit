package common.credit.dubbo;


import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
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


    public Document applyNotify(MybankCreditLoanApplyNotifyRequest request, MybankCreditLoanApplyNotifyResponse response);

    public Document approveUpload(MybankCreditLoanApproveUploadRequest request, MybankCreditLoanApproveUploadResponse response);


    public Document finalNotify(MybankCreditLoanApproveackNotifyRequest request, MybankCreditLoanApproveackNotifyResponse response);


    public Document finalConfirm(MybankCreditLoanApproveackConfirmRequest request, MybankCreditLoanApproveackConfirmResponse response);

}
