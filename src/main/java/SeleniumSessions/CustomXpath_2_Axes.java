package SeleniumSessions;

//Watch the Video again

public class CustomXpath_2_Axes {

	public static void main(String[] args) {

		// https://classic.crmpro.com/

		// parent to child:
		// (//div[@class='navFooterLinkCol navAccessibility'])[position()=1]//a
		// direct child --- single slash
		// indirect child which is not direct --- double slash
		// direct child: /
		// all the child including indirect child : //
		// https://app.hubspot.com/login

		// (//form[@id='hs-login']/button)[1]
		// //form[@id='hs-login']//input

		// https://classic.crmpro.com/
		// parent to child:
		// div[@class='input-group']//child::input --- under parent div give me the
		// immediate child elements having tag name as input

		// child to parent:
		// backward traversing in xpath:
		// input[@name='username']/../../../../../../..
		// input[@name='username']//parent::div//parent::form //give me all the immediate parent having tag div, then give me all the immediate parent having tag
		//name as form
		// input[@name='username']//ancestor::form - takes you to the grand parent

		// https://classic.freecrm.com/

		// preceding-sibling:
		// a[text()='Ali Baba']//parent::td//preceding-sibling::td/input ---td to td are
		// not parent child, they are at the same level
		// left navigation is preceeding
		// right navigation is forward

		// a[text()='Alex DAN']//parent::td//following-sibling::td/a ---6
		// a[text()='Alex DAN']//parent::td//following-sibling::td/a[@context='company']
		// ---1

		// ----------------------------------------------

		// parent child
		// (//div[@class='navFooterLinkCol navAccessibility'])[position()=2]//a

		// direct child: /
		// all the child : //
		// (//form[@id='hs-login']/button)[1]
		// //form[@id='hs-login']//input

		// parent to child:
		// div[@class='input-group']//child::input

		// child to parent:
		// backward traversing in xpath:
		// input[@name='username']/../../../../../../..
		// input[@name='username']//parent::div//parent::form

		// input[@name='username']//ancestor::form

		// preceding-sibling:
		// a[text()='Ali Baba']//parent::td//preceding-sibling::td/input
		// a[text()='Alex DAN']//parent::td//following-sibling::td/a ---6
		// a[text()='Alex DAN']//parent::td//following-sibling::td/a[@context='company']
		// ---1

	}
}
