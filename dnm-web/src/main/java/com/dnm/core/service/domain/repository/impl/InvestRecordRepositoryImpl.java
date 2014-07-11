/**
 * zhm.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.dnm.core.service.domain.repository.impl;

import com.dnm.core.service.domain.AbstractDomainService;
import com.dnm.core.service.domain.enums.AccessorEnum;
import com.dnm.core.service.domain.enums.RepoActionEnum;
import com.dnm.core.service.domain.model.bill.InvestRecordModel;
import com.dnm.core.service.domain.repository.InvestRecordRepository;
import com.dnm.core.service.domain.repository.access.AccessorActionDef;

/**
 * Ͷ���¼����ִ�
 * 
 * @author hongmin.zhonghm
 * @version $Id: InvestRecordRepositoryImpl.java, v 0.1 2014-5-25 ����7:26:22 hongmin.zhonghm Exp $
 */
public class InvestRecordRepositoryImpl extends AbstractDomainService implements InvestRecordRepository {

    /** 
     * @see com.dnm.core.service.domain.repository.InvestRecordRepository#store(com.dnm.core.service.domain.model.bill.InvestRecordModel)
     */
    @Override
    public void store(InvestRecordModel model) {
    	//step1.ģ��У��
        model.checkConsistency();

        //����ִ���Ϊ
        AccessorActionDef actionDef = defAction(model);

        //ģ�ʹ洢
        accessModel(model, actionDef);
    }
    
    /**
     * ���������ָ��
     * @param model
     * @return
     */
    private AccessorActionDef defAction(InvestRecordModel model){
    	//����
        AccessorActionDef actionDef = defAction(AccessorEnum.INVEST_RCD, RepoActionEnum.STORE);
        //��ϸ��
        actionDef.addAction(AccessorEnum.INVEST_DUEIN_RCD, RepoActionEnum.STORE);
        //�˻���Դ
        actionDef.addAction(AccessorEnum.INVEST_FROM_ACCOUNT, RepoActionEnum.STORE);
        //��������
        actionDef.addAction(AccessorEnum.INVEST_PRICE_COST, RepoActionEnum.STORE);
        
        return actionDef;
    }

}
