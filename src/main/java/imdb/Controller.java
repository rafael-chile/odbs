package imdb;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Controller {

	
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TagsListModel getListTags() {
		List<String> tagslist = new ArrayList<>();
		
		
		
		
		return new TagsListModel(tagslist);
	}
	
	
	private class TagsListModel implements ListModel{

		List<String> tags;
		
		TagsListModel(List<String> l)
		{
			tags=l;
		}
		
		@Override
		public int getSize() {
			return tags.size();
		}

		@Override
		public Object getElementAt(int index) {
			return tags.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
