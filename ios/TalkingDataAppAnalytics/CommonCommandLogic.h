//
//  CommonCommandLogic.h
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <XcodeKit/XcodeKit.h>



@interface CommonCommandLogic : NSObject<XCSourceEditorCommand>

- (void)insertEditableWithInvocation:(XCSourceEditorCommandInvocation *)invocation contents:(NSString *)contents editPosition:(NSInteger)editPosition;

@end


