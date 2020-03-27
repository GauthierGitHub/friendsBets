import { User } from './User.model';
import { Group } from './Group.model';
import { IFriendsBetsModels } from './models-interfaces/IFriendsBetsModels';

export class Message implements IFriendsBetsModels {
    
    readonly IS_MODEL: boolean = true;
    private _id: number;
    private _author: User;
    private _group: Group;
    private _date: Date;
    private _content: string;

    
    constructor();
    constructor(id: number, author: User, group: Group, content: string);
    constructor(id?);
    constructor(id?: number, author?: User, group?: Group, content?: string) {
        this._id = id ? id : 0;
        this._author = author ? author : new User();
        this._group = group ? group : new Group();
        this._content = content ? content : "";
    }

    get id(): number {
        return this._id;
    }
    set id(id: number) {
        this._id = id;
    }

    get author(): User {
        return this._author;
    }
    set author(u: User) {
        this._author = u;
    }

    get group(): Group {
        return this._group;
    }
    set group(g: Group) {
        this._group = g;
    }

    get date(): Date {
        return this._date;
    }
    set date(d: Date) {
        this._date = d;
    }

    get content(): string {
        return this._content;
    }
    set content(c: string) {
        this._content = c;
    }
}