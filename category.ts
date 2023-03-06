export class Category {
    constructor(public category_id:number,
        public category_name:string,
        public created_user:string,
        public created_date_time:Date,
        public last_modified_user:string,
        public last_modified_date_time:Date)
    {

    }
}
