package com.huanong.lab.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huanong.lab.bean.Code;
import com.huanong.lab.bean.CodeExample;
import com.huanong.lab.bean.Product;
import com.huanong.lab.dao.CodeMapper;
import com.huanong.lab.dao.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	CodeMapper codeMapper;

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test(){
		System.out.print(productMapper);
		ProductMapper productmapper = sqlSession.getMapper(ProductMapper.class);
		CodeMapper codeMapper = sqlSession.getMapper(CodeMapper.class);
//		productmapper.insertSelective(new Product(null, "韩之味芦荟膏200g", "便宜实用"));
//		productmapper.insertSelective(new Product(null, "日之声蓝牙耳机r3", "高端大气"));
//		codeMapper.insertSelective(new Code(null, "qweasdzxc", null, null, 1));
//		codeMapper.insertSelective(new Code(null, "asd123fgh", null, null, 1));
//		codeMapper.insertSelective(new Code(null, "jkl456iop", null, null, 1));
//		codeMapper.insertSelective(new Code(null, "zxc789qwe", null, null, 2));
//		codeMapper.insertSelective(new Code(null, "fghrtyvbn", null, null, 2));
//		codeMapper.insertSelective(new Code(null, "yui567bnm", null, null, 2));
		System.out.println(codeMapper.selectByPrimaryKeyWithProduct(1));
		
	}
}
