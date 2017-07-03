# ListViewDeleteItem-master
炫酷的滑动删除ListView

![image](https://github.com/mengcuiguang/ListViewDeleteItem-master/blob/master/test.gif )  

使用方法：使用系统的Listview，滑动不同之处在于ListAdapter中，对要删除的item进行处理

1、布局文件

        <ListView
            android:id="@+id/list"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        </ListView>
    
2、MainActivity 

        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(this, createList(20));
        listView.setAdapter(adapter);

3、ListAdapter

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_list, parent, false);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text);
            holder.deleteView = convertView.findViewById(R.id.delete_layout);
            holder.swipeLayout = (SwipeRevealLayout) convertView.findViewById(R.id.swipe_layout);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final String item = getItem(position);
        if (item != null) {
            binderHelper.bind(holder.swipeLayout, item);

            holder.textView.setText(item);
            holder.deleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(item);

                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

