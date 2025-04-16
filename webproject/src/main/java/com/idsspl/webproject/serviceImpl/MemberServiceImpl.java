package com.idsspl.webproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idsspl.webproject.entity.MemberEntity;
import com.idsspl.webproject.repo.MemberRepo;
import com.idsspl.webproject.model.MemberModel;
import com.idsspl.webproject.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;

	@Override
	public List<MemberModel> getMemberList(MemberModel member) {
		System.out.println("name----" + member.getName());
		List<MemberEntity> memberEntityList = null;
		System.out.println("member name----" + member.getName() + "---------");
		memberEntityList = memberRepo.findByCustomerName(member.getName());

		System.out.println("member name----" + member.getName() + "---------");
		List<MemberModel> memberModelList = new ArrayList<>();

		memberEntityList.stream().forEach(memberEntity -> {
			MemberModel memberModel = new MemberModel();
			memberModel.setAccountCode(memberEntity.getAccountCode());
			memberModel.setCustomerId(memberEntity.getCustomerId());
			memberModel.setName(memberEntity.getName());
			memberModel.setAccountType(memberEntity.getAccountType());
			memberModel.setMobile(memberEntity.getMobile());
			memberModel.setAreaname(memberEntity.getAreaname());
			memberModel.setLocalLanguageName(memberEntity.getLocalLanguageName());
			memberModelList.add(memberModel);

		});

		return memberModelList;
	}

}
