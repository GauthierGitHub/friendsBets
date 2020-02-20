import { User } from '../user.model';

export interface TypedObject {
    jsonType: string;
}

export class UserSerializer {

    static serializetoJSON(u: User) {
        // TODO: add token ?
        let string =
        {
            "nickname": u.alias,
            "password": u.password,
            "email": u.email,
            "picturePath": null,
            "token": null,
            "tokenLastUsed": null
        }
        return string;
    }

    // private static stringToObject(s: String): Object {
    //     switch (s) {
    //         case "User": return new User();
    //         // case "Administrator": return new Administrator();
    //         default: return new Object();
    //     }
    // }
    // private static objectToString(o: Object): string {
    //     return o.constructor.name;
    // }


    // private static removeUnderscore(o: Object) {
    //     let n: Object = {};
    //     Object.keys(o).forEach(k => n[k.startsWith("_") ? k.substring(1) : k] = o[k] );
    //     return n;
    // }

    // private static addUnderscore(o: Object) {
    //     let n: Object = {};
    //     Object.keys(o).forEach(k => n[k.startsWith("_") ? k : "_" + k] = o[k] );
    //     return n;
    // }

    
	// static deserialize<T>(o: TypedObject): T {
    //     return  Object.assign(this.stringToObject(o.jsonType) as T, this.addUnderscore(o));
	// }

	// static serialize<T>(o: T): Object {
    //     return  Object.assign(new Object(), {jsonType: this.objectToString(o)}, this.removeUnderscore(o));
	// }

}