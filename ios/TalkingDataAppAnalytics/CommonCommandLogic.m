//
//  CommonCommandLogic.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "CommonCommandLogic.h"

@implementation CommonCommandLogic

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    completionHandler(nil);
}

- (void)insertEditableWithInvocation:(XCSourceEditorCommandInvocation *)invocation contents:(NSString *)contents editPosition:(NSInteger)editPosition{
    if (invocation.buffer.selections.count > 0 && invocation.buffer.lines.count > 0) {
        XCSourceTextRange *selection = invocation.buffer.selections.firstObject;
        NSInteger index = selection.start.line;
        
        XCSourceTextPosition startPosition = { .line = index, .column = editPosition };
        XCSourceTextPosition endPosition = { .line = index, .column = editPosition };
        
        XCSourceTextRange *updatedSelection = [[XCSourceTextRange alloc] initWithStart:startPosition end:endPosition];
        
        [invocation.buffer.lines insertObject:contents atIndex:index];
        [invocation.buffer.selections removeAllObjects];
        [invocation.buffer.selections addObject:updatedSelection];
    }
}

@end
