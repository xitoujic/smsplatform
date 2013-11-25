/**
 *@time 2011-3-20
 *@author soledad pisces
 *@fileName ITextPdf.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.hanphon.recruit.domain.StudentDomain;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author soledad pisces
 * 
 */
public class ApplyPdfCreate {
	private Document document = null;
	private BaseFont bfChinese = null;
	private HashMap<String, String> properties = null;
	private InputStream pdfStream = null;
	private StudentDomain studentDomain = null;

	public ApplyPdfCreate(StudentDomain studentDomain) throws JDOMException {
		this.studentDomain = studentDomain;

		try {
			Rectangle pSize = new Rectangle(PageSize.A4);
			document = new Document(pSize, 50, 50, 50, 50);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			@SuppressWarnings("unused")
			PdfWriter pdfWriter = PdfWriter.getInstance(document, buffer);

			createPdf();

			document.open();
			document.newPage();

			bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/simfang.ttf",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

			loadXMLFile();

			addHead();
			addApplyTable();
			addTail();

			document.close();

			this.pdfStream = new ByteArrayInputStream(buffer.toByteArray());
			buffer.close();
			// System.out.println("完成");

		} catch (DocumentException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * @throws IOException
	 * @throws JDOMException
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void loadXMLFile() throws JDOMException, IOException {
		org.jdom.Document xmlDocument = null;
		SAXBuilder saxBuilder = new SAXBuilder();
		xmlDocument = saxBuilder.build(ApplyPdfCreate.class.getClassLoader()
				.getResourceAsStream("apply.cfg.xml"));
		Element root = xmlDocument.getRootElement();
		List<Element> list = null;
		list = root.getChildren();
		properties = new HashMap<String, String>();
		Iterator allTagIterator = list.iterator();

		while (allTagIterator.hasNext()) {
			Element element = (Element) allTagIterator.next();
			String elementValue = element.getText();
			String elementKey = element.getName();
			properties.put(elementKey, elementValue);
		}
	}

	/**
	 * @param document
	 * @throws DocumentException
	 */
	private void addTail() throws DocumentException {
		Font fontHead = new Font(bfChinese, 12, Font.NORMAL);
		Paragraph tailParagraph = new Paragraph(properties.get("tail"),
				fontHead);
		tailParagraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
		tailParagraph.setExtraParagraphSpace(10);
		tailParagraph.setLeading(20.0f);
		document.add(tailParagraph);
	}

	/**
	 * @param document
	 * @throws DocumentException
	 */
	private void addHead() throws DocumentException {
		Font fontTitle = new Font(bfChinese, 15, Font.BOLD);
		Paragraph headParagraph = new Paragraph(properties.get("title"),
				fontTitle);
		headParagraph.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		headParagraph.setExtraParagraphSpace(20);
		headParagraph.setLeading(20.0f);
		document.add(headParagraph);

		headParagraph = new Paragraph("\n");
		document.add(headParagraph);
	}

	/**
	 * @param document
	 * @throws DocumentException
	 */
	private void addApplyTable() throws DocumentException {
		Font fontTable = new Font(bfChinese, 10, Font.NORMAL);
		PdfPTable table = new PdfPTable(8);

		table.setWidthPercentage(100.f);
		table.getDefaultCell().setHorizontalAlignment(
				com.itextpdf.text.Element.ALIGN_CENTER);
		table.getDefaultCell().setLeading(1.4f, 1.4f);
		
		PdfPCell cell1 = null;
		table.addCell(new Phrase("姓名", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserName(), fontTable));
		table.addCell(cell1);

		table.addCell(new Phrase("性别", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserSex(), fontTable));
		table.addCell(cell1);

		table.addCell(new Phrase("出生日期", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserBirthday(),
				fontTable));
		table.addCell(cell1);

		PdfPCell cell = new PdfPCell(new Phrase("照片", fontTable));
		cell.setColspan(2);
		cell.setRowspan(5);
		table.addCell(cell);

		table.addCell(new Phrase("民族", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserNation(),
				fontTable));
		table.addCell(cell1);
		table.addCell(new Phrase("报考类型", fontTable));
		
		if("普通".equals(studentDomain.getUserCategory())){
			cell1 = new PdfPCell(new Phrase("[√]普通 []体艺",
					fontTable));
		}else{
			cell1 = new PdfPCell(new Phrase("[]普通 [√]体艺",
					fontTable));
		}
		
		table.addCell(cell1);
		table.addCell(new Phrase("政治面貌", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserPolStatus(),
				fontTable));
		table.addCell(cell1);
		cell.setColspan(2);

		table.addCell(new Phrase("邮政编码", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getUserPostalCode(),
				fontTable));
		table.addCell(cell1);
		table.addCell(new Phrase("联系人", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getLinkMan(), fontTable));
		table.addCell(cell1);
		table.addCell(new Phrase("联系电话", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getLinkPhoneNum(),
				fontTable));
		table.addCell(cell1);

		table.addCell(new Phrase("通讯地址", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain.getUserAddress(),
				fontTable));
		cell.setColspan(5);
		table.addCell(cell);

		table.addCell(new Phrase("电子邮件", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain.getUserEmail(), fontTable));
		cell.setColspan(5);
		table.addCell(cell);

		table.addCell(new Phrase("毕业中学", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain.getJuniorSchoolName(),
				fontTable));
		cell.setColspan(2);
		table.addCell(cell);
		table.addCell(new Phrase("中学地址", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain.getJuniorSchoolAddress(),
				fontTable));
		cell.setColspan(2);
		table.addCell(cell);
		table.addCell(new Phrase("邮件编码", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJuniorSchoolPostalCode(), fontTable));
		table.addCell(cell1);

		table.addCell(new Phrase("联系人", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain.getJuniorSchoolLinkman(),
				fontTable));
		cell.setColspan(2);
		table.addCell(cell);
		table.addCell(new Phrase("联系电话", fontTable));
		cell = new PdfPCell(new Phrase(studentDomain
				.getJuniorSchoolLinkPhoneNum(), fontTable));
		cell.setColspan(2);
		table.addCell(cell);
		table.addCell(new Phrase("中学传真", fontTable));
		cell1 = new PdfPCell(new Phrase(studentDomain.getJuniorSchoolFax(),
				fontTable));
		table.addCell(cell1);

		table.addCell(new Phrase("学期", fontTable));
		table.addCell(new Phrase("语文", fontTable));
		table.addCell(new Phrase("数学", fontTable));
		table.addCell(new Phrase("英语", fontTable));
		table.addCell(new Phrase("物理", fontTable));
		table.addCell(new Phrase("化学", fontTable));
		table.addCell(new Phrase("历史", fontTable));
		table.addCell(new Phrase("政治", fontTable));

		// 考试1
		cell1.setPadding(10.0f);
		cell1 = new PdfPCell(new Phrase("初二上学期期末考试", fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreChinese()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreMath()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreEnglish()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreHpy()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreChem()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PreHistory()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2PrePoli()
				.toString(), fontTable));
		table.addCell(cell1);

		// 考试2
		cell1.setPadding(10.0f);
		cell1 = new PdfPCell(new Phrase("初二下学期期末考试", fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextChinese()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextMath()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextEnglish()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextHpy()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextChem()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextHistory()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior2NextPoli()
				.toString(), fontTable));
		table.addCell(cell1);

		// 考试3
		cell1.setPadding(10.0f);
		cell1 = new PdfPCell(new Phrase("初三上学期期末考试", fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreChinese()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreMath()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreEnglish()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreHpy()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreChem()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PreHistory()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3PrePoli()
				.toString(), fontTable));
		table.addCell(cell1);

		// 考试4
		cell1.setPadding(10.0f);
		cell1 = new PdfPCell(new Phrase("初三下学期期中考试", fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3NextMidChinese().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3NextMidMath()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3NextMidEnglish().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3NextMidHpy()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3NextMidChem()
				.toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3NextMidHistory().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain.getJunior3NextMidPoli()
				.toString(), fontTable));
		table.addCell(cell1);

		// 考试5
		cell1.setPadding(10.0f);
		cell1 = new PdfPCell(new Phrase("无锡市高考一模", fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamChinese().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamMath().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamEnglish().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamHpy().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamChem().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamHistory().toString(), fontTable));
		table.addCell(cell1);
		cell1 = new PdfPCell(new Phrase(studentDomain
				.getJunior3Next1stShamPoli().toString(), fontTable));
		table.addCell(cell1);

		PdfPCell cell3 = new PdfPCell(
				new Phrase("有何爱好\n和特长 \n取得何成绩", fontTable));
		cell3.setMinimumHeight(50.0f);
		cell3.setPadding(10.0f);
		cell3.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		cell3.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_BOTTOM);
		cell3.setColspan(2);
		table.addCell(cell3);
		cell1 = new PdfPCell(
				new Phrase(studentDomain.getUserHobby(), fontTable));
		cell1.setColspan(6);
		table.addCell(cell1);
		document.add(table);

		Font fontTitle = new Font(bfChinese, 10, Font.BOLD);
		Paragraph paragraph = new Paragraph("\n");
		document.add(paragraph);
		paragraph = new Paragraph("学校推荐意见", fontTitle);
		document.add(paragraph);
		paragraph = new Paragraph("\n");
		document.add(paragraph);

		PdfPTable table2 = new PdfPTable(1);
		table2.setWidthPercentage(100.f);
		PdfPCell cellSchoole = new PdfPCell(new Phrase(
				"校长签字：            盖章\n  日期：   年    月", fontTable));
		cellSchoole.setPadding(80.0f);
		cellSchoole
				.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
		cellSchoole.setPaddingBottom(2);
		table2.addCell(cellSchoole);

		document.add(table2);

		paragraph = new Paragraph("\n");
		document.add(paragraph);
		paragraph = new Paragraph(
				"申请人签字：▁▁▁▁▁▁▁▁▁▁▁▁              填表时间：▁▁▁▁▁▁▁▁▁▁▁▁", fontTitle);
		document.add(paragraph);

	}

	/**
	 * @param document
	 */
	private void createPdf() {
		document.addAuthor("hanphon");
		document.addTitle("自主招生申请表");
		document.addProducer();
		document.addCreationDate();
	}

	public InputStream getPdfStream() {
		return pdfStream;
	}

	public void setPdfStream(InputStream pdfStream) {
		this.pdfStream = pdfStream;
	}

}
