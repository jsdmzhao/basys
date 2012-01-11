package com.aisino2.techsupport.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.dao.IAttachmentDao;
import com.aisino2.techsupport.domain.Attachment;

@Component
public class AttachmentDaoImpl extends TechSupportBaseDao implements
		IAttachmentDao {

	public void insert(Attachment attachement) {
		attachement.setAttachmentId(this.getNextID("seq_ts_attach"));
		this.insert("Attachment.insert", attachement);
	}

	public void delete(Attachment attachement) {
		this.delete("Attachment.delete", attachement);
	}

	public void update(Attachment attachement) {
		this.update("Attachment.update", attachement);
	}

	public Page queryForPage(Map<String, Object> map, int pageno,
			int pagesize, String sort, String desc) {
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " t.attachment_id "+ desc;
			else if(sort.equals("1"))
				sCol = " t.attachemnt_name "+ desc;
			else if(sort.equals("2"))
				sCol = " t.attachemnt_size "+ desc;
			else if(sort.equals("3"))
				sCol = " t.attachemnt_comment "+ desc;
			else
				sCol = " t.attachment_id ";
		}else{
			sCol=" t.attachment_id ";
		}
		map.put("pageSort", sCol);
		return this.queryForPage("Attachment.queryForPage", map, pageno,pagesize);
	}

	public List<Attachment> query(Attachment attachement) {
		return this.queryForList("Attachment.query", attachement);
	}

	public Attachment get(Attachment attachment) {
		return (Attachment) this.queryForObject("Attachment.get", attachment);
	}

}
