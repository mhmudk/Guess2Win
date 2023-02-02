package com.example.guess2win.homepagedetails.matches

//class MatchesListAdapter(var matchesList: ArrayList<MatchItemUIModel>) :
//    RecyclerView.Adapter<BaseViewHolder>() {
//    lateinit var matchesListInterface: MatchesListInterface
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
//        return MatchesListHolder(
////            ListOfMatchesBinding.inflate(
////                LayoutInflater.from(
////                    parent.context
////                ), parent, false
////            )
//        )
//    }
//
//    override fun getItemCount(): Int = matchesList.size
//
//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        holder.onBind(position)
//        holder.itemView.setOnClickListener {
//            matchesListInterface.onClick(
//                matchesList[position]
//            )
//        }
//    }
//
////    inner class MatchesListHolder(var binding: ListOfMatchesBinding) :
////       // BaseViewHolder(binding.root) {
////        override fun onBind(position: Int) {
////        //  binding.model = matchesList[position]
////        }
////    }
//
//    interface MatchesListInterface {
//        fun onClick(match: MatchItemUIModel)
//    }
//}