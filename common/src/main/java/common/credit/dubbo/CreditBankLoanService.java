package common.credit.dubbo;


import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import common.credit.request.CustMybankCreditLoanApproveUploadRequest;
import common.credit.result.ResponseResult;

public interface CreditBankLoanService {

    /*
     * 初审通知请求，网商银行-银行机构
     */
    public ResponseResult applyNotify(AlipayHeader head,
                                      MybankCreditLoanApplyNotifyDomain domain,
                                      MybankCreditLoanApplyNotifyResponse response);

    /*
     * 初审数据上传，银行机构-网商银行
     */
    public ResponseResult approveUpload(AlipayHeader head,
                                        MybankCreditLoanApproveUploadResponse body,
                                        CustMybankCreditLoanApproveUploadRequest request);

    /*
     * 终审通知，网商银行-银行机构
     */
    public ResponseResult finalNotify(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder,
                                MybankCreditLoanApproveackNotifyResponse response);

    /*
     * 终审确认，银行机构-网商银行
     */
    public ResponseResult finalConfirm(MybankCreditLoanApproveackConfirmRequest request,
                                 ParametersHolder<MybankCreditLoanApproveackConfirmResponse> response);

}
