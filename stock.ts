export class Stock {
    constructor(public ref_id:number,public branch_id:number,public created_user:String,
        public  date_stock:Date,public last_modified_date_time:Date,
        public last_modified_user:string,public quantity:number  )
    {

    }
}
